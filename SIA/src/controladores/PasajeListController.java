/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Conexion;
import entidades.Pasaje;
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
import lanzadores.AdministradorLaunch;
import lanzadores.PasajeListLaunch;


/**
 * FXML Controller class
 *
 * @author Pablo I
 */
public class PasajeListController implements Initializable {

    @FXML
    private TableColumn<Pasaje, Integer> tbIdPasaje;
    @FXML
    private TableColumn<Pasaje, Integer> tbClase;
    @FXML
    private TableColumn<Pasaje, String> tbAsiente;
    @FXML
    private TableColumn<Pasaje, Float> tbValor;
    @FXML
    private TableColumn<Pasaje, Integer> tbIdCliente;
    @FXML
    private TableColumn<Pasaje, Integer> tbIdVuelo;
    @FXML
    private TableColumn<Pasaje, String> tbLastU;
    @FXML
    private TableColumn<Pasaje, String> tbLastB;
    @FXML
    
    public ObservableList<Pasaje> data = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Pasaje> tvPasaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
                Pasaje p = new Pasaje();
                p = tvPasaje.getSelectionModel().getSelectedItem();
                //p.delete();}
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
                
        
        tvPasaje.setContextMenu(menu);
    }
    
    @FXML
    private void regresar(ActionEvent event) {
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
        PasajeListLaunch pll = new PasajeListLaunch();
        pll.launch();
    }
    
    public void setTable(){
        tbIdPasaje.setCellValueFactory(new PropertyValueFactory<>("idPasaje"));
        tbClase.setCellValueFactory(new PropertyValueFactory<>("idClase"));
        tbAsiente.setCellValueFactory(new PropertyValueFactory<>("asiento"));
        tbValor.setCellValueFactory(new PropertyValueFactory<>("precioBase"));
        tbIdCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        tbIdVuelo.setCellValueFactory(new PropertyValueFactory<>("idVuelo"));
        tvPasaje.setItems(data);
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
                Pasaje p = new Pasaje();
                p.setIdPasaje(r1.getInt("idPasaje"));
                p.setClase(r1.getString("idClase"));
                p.setAsiento(r1.getString("asiento"));
                p.setValor(r1.getFloat("precioBase"));
                p.setIdCliente(r1.getInt("idCliente"));
                p.setIdVuelo(r1.getInt("idVuelo"));
                data.add(p);
            }
        } catch (Exception e) {
      
        }
    }
}
