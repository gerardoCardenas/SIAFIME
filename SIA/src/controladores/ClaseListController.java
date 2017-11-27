/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Conexion;
import entidades.Clase;
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
import lanzadores.ClaseListLaunch;

/**
 * FXML Controller class
 *
 * @author Pablo I
 */
public class ClaseListController implements Initializable {

    @FXML
    private TableColumn<Clase, Integer> tbcIdClase;
    @FXML
    private TableColumn<Clase, String> tbcDesc;
    @FXML
    private TableColumn<Clase, Float> tbcAum;
    @FXML
    private TextField txfBus;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<Clase> tvClase;

    public ObservableList<Clase> data = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        rellenarTabla();
    }    
    
    private void opciones(ContextMenuEvent event) {
        ContextMenu menu = new ContextMenu();
        MenuItem itemActualizar = new MenuItem("Actualizar");
        itemActualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rellenarTabla();
            }
        });
        menu.getItems().add(itemActualizar);
                
        
        tvClase.setContextMenu(menu);
    }
    
    @FXML
    private void regresar(ActionEvent event) {
        ClaseListLaunch oll = new ClaseListLaunch();
        oll.close();
        AdministradorLaunch al = new AdministradorLaunch();
        al.launch();
    }
    
    public void setTable(){
        tbcIdClase.setCellValueFactory(new PropertyValueFactory<>("idClase"));
        tbcDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tbcAum.setCellValueFactory(new PropertyValueFactory<>("aumento"));
        tvClase.setItems(data);
    }
    
    public void rellenarTabla(){
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `clase`";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Clase c = new Clase();
                c.setIdClase(r1.getInt("idClase"));
                c.setDescripcion(r1.getString("descripcion"));
                c.setAumento(r1.getFloat("aumento"));
                data.add(c);
            }
        } catch (Exception e) {
      
        }
    }
    
}
