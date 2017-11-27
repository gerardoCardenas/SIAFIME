/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Conexion;
import db.Sesion;
import entidades.Clase;
import entidades.Vuelo;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javax.swing.JOptionPane;
import lanzadores.AdministradorLaunch;
import lanzadores.EmpleadoLaunch;
import lanzadores.RegistrarClienteLaunch;
import lanzadores.RegistrarClienteVueloLaunch;
import lanzadores.VueloListLaunch;
import sia.Reservacion;

/**
 * FXML Controller class
 *
 * @author emmanuel
 */
public class VuelosController implements Initializable {

    @FXML
    private TableColumn<Vuelo, Integer> tbcIdVuelo;
    @FXML
    private TableColumn<Vuelo, Integer> tbcCapacidad;
    @FXML
    private TableColumn<Vuelo, Integer> tbcOri;
    @FXML
    private TableColumn<Vuelo, Integer> tbcDest;
    @FXML
    private TableColumn<Vuelo, Float> tbcPre;
    @FXML
    private TableColumn<Vuelo, String> tbcMod;
    @FXML
    private TableColumn<Vuelo, Integer> tbcIdEsc;
    @FXML
    private TableColumn<Vuelo, Integer> tbcAerolineas;
    @FXML
    private TextField txfBuscar;
    @FXML
    private Button btnBuscar;

    public ObservableList<Vuelo> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Vuelo> tvVuelo;
    @FXML
    private TableColumn<?, ?> tbcAero;
    
    @FXML
    private ComboBox<Clase> cbClase;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        rellenarTabla();
        rellenarCombo();
    }    

     private void buscar(ActionEvent event) {
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String nombre;
        nombre = tbcMod.getText();
        String query = "SELECT * FROM `vuelo` WHERE modeloAvion = '"+nombre+"'";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Vuelo v = new Vuelo(r1.getInt("capacidad"),
                        r1.getInt("idOrigen"), r1.getInt("idDestino"),
                        r1.getFloat("precioBase"), r1.getString("modeloAvion"), 
                        r1.getInt("idEscala"), r1.getInt("idAerolinea"));
                v.setIdVuelo(r1.getInt("idVuelo"));
                data.add(v);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
        }
    }
    
    @FXML
    private void regresar(ActionEvent event) {
        if(Sesion.obtenerObjetoUsuario().getTipoUsuario().equals("Administrador"))
        {
            AdministradorLaunch al1 = new AdministradorLaunch();
            al1.launch();
            VueloListLaunch vll = new VueloListLaunch();
            vll.close();
        }
        else{
            EmpleadoLaunch el = new EmpleadoLaunch();
            el.launch();
            VueloListLaunch vll = new VueloListLaunch();
            vll.close();
        }
    }
    
    public void setTable(){
        tbcIdVuelo.setCellValueFactory(new PropertyValueFactory<>("idVuelo"));
        tbcCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidad"));
        tbcOri.setCellValueFactory(new PropertyValueFactory<>("idOrigen"));
        tbcDest.setCellValueFactory(new PropertyValueFactory<>("idDestino"));
        tbcPre.setCellValueFactory(new PropertyValueFactory<>("precioBase"));
        tbcMod.setCellValueFactory(new PropertyValueFactory<>("modeloAvion"));
        tbcIdEsc.setCellValueFactory(new PropertyValueFactory<>("idEscala"));
        tbcAerolineas.setCellValueFactory(new PropertyValueFactory<>("idAerolinea"));
        tvVuelo.setItems(data);
    }
    
    public void rellenarTabla(){
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `vuelo`";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Vuelo v = new Vuelo();
                v.setIdVuelo(r1.getInt("idVuelo"));
                v.setIdOrigen(r1.getInt("idOrigen"));
                v.setIdDestino(r1.getInt("idDestino"));
                v.setPrecioBase(r1.getFloat("precioBase"));
                v.setModeloAvion(r1.getString("modeloAvion"));
                v.setIdEscala(r1.getInt("idEscala"));
                v.setIdAerolinea(r1.getInt("idAerolinea"));
                v.setCapacidad(r1.getInt("capacidad"));
                data.add(v);
            }
        } catch (Exception e) {
            
        }
    }

    @FXML
    private void opciones(ContextMenuEvent event) {
        ContextMenu menu = new ContextMenu();
        MenuItem itemReservar =new MenuItem("Reservar");
        itemReservar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Vuelo v = tvVuelo.getSelectionModel().getSelectedItem();
                Reservacion.setVuelo(v);
                try {
                   Reservacion.setClase(cbClase.getSelectionModel().getSelectedItem());
                   if(Reservacion.getClase().getDescripcion().equals("")){
                       throw new Exception("Porfavor elija una clase");
                   }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Porfavor elija una clase");
                }
                RegistrarClienteVueloLaunch rcl = new RegistrarClienteVueloLaunch();
                rcl.launch();;
                VueloListLaunch vll = new VueloListLaunch();
                vll.close();
            }
        });
        menu.getItems().add(itemReservar);
        tvVuelo.setContextMenu(menu);
    }
    private void rellenarCombo(){
        
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `clase`";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Clase clase = new Clase();
                clase.setDescripcion(r1.getString("descripcion"));
                clase.setAumento(r1.getFloat("aumento"));
                clase.setIdClase(r1.getInt("idClase"));
                cbClase.getItems().add(clase);
            }
        } catch (Exception e) {
        }
        
    }
}
