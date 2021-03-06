/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Conexion;
import entidades.Aerolinea;
import entidades.Ciudad;
import entidades.Origen;
import facade.AerolineaFacade;
import facade.CiudadFacade;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javax.swing.JOptionPane;
import lanzadores.AdministradorLaunch;
import lanzadores.OrigenListLaunch;

/**
 * FXML Controller class
 *
 * @author Gerardo Cardenas
 */
public class OrigenListController implements Initializable {

    @FXML
    private TableView<Origen> tbAerolinea;
    @FXML
    private TableColumn<Origen, Integer> tcAerolinea;
    @FXML
    private TableColumn<Origen, Integer> tcCiudad;
    @FXML
    private TableColumn<Origen, String> tbcFMod;
    @FXML
    private TableColumn<Origen, String> tbcModP;

    public ObservableList<Origen> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Origen, Integer> tbcIdOrigen;
    @FXML
    private TextField txfBusc;
    @FXML
    private Button btnButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        rellenarTabla();
    }    

    @FXML
    private void opciones(ContextMenuEvent event) {
        ContextMenu menu = new ContextMenu();
        MenuItem itemEditar =new MenuItem("Editar");
        MenuItem itemEliminar = new MenuItem("Eliminar");
        MenuItem itemActualizar = new MenuItem("Actualizar");
        itemEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Origen origen = new Origen();
                origen = tbAerolinea.getSelectionModel().getSelectedItem();
                origen.delete();
            }
        });
        menu.getItems().add(itemEliminar);
        itemActualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rellenarTabla();
            }
        });
        menu.getItems().add(itemActualizar);
                
        
        tbAerolinea.setContextMenu(menu);
    }



    @FXML
    private void regresar(ActionEvent event) {
        OrigenListLaunch oll = new OrigenListLaunch();
        oll.close();
        AdministradorLaunch al = new AdministradorLaunch();
        al.launch();
    }
    
    public void setTable(){
        tbcIdOrigen.setCellValueFactory(new PropertyValueFactory<>("idOrigen"));
        tcAerolinea.setCellValueFactory(new PropertyValueFactory<>("aerolinea"));
        tcCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        tbcFMod.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        tbcModP.setCellValueFactory(new PropertyValueFactory<>("lastUpdateBy"));
        tbAerolinea.setItems(data);
    }
    public void rellenarTabla(){
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `origen`";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Origen o = new Origen();
                o.setIdOrigen(r1.getInt("idOrigen"));
                o.setAerolinea(r1.getInt("idAerolinea"));
                o.setCiudad(r1.getInt("idCiudad"));
                o.setLastUpdate(r1.getString("lastUpdate"));
                o.setLastUpdateBy(r1.getString("lastUpdateBy"));
                data.add(o);
            }
        } catch (Exception e) {
      
        }
    }
    
    @FXML
    private void Buscar (ActionEvent event){
        data.clear();
        Conexion c1 =new Conexion();
        Connection co = c1.conectar();
        String descrip;
        descrip = txfBusc.getText();
        String query = "SELECT * FROM `origen` WHERE idAerolinea = '"+descrip+"'";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Origen o1 = new Origen(r1.getInt("idAerolinea"));
                o1.setAerolinea(r1.getInt("idCiudad"));
                o1.setLastUpdate(r1.getString("lastUpdate"));
                o1.setLastUpdateBy(r1.getString("lastUpdateBy"));
                data.add(o1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
        }
    }
}
