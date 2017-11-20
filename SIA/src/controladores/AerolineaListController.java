/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Conexion;
import entidades.Aerolinea;
import entidades.Usuario;
import facade.AerolineaFacade;
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
import lanzadores.AerolineaListLaunch;
import lanzadores.RegistrarAerolineaLaunch;

/**
 * FXML Controller class
 *
 * @author Pablo I
 */
public class AerolineaListController implements Initializable {

    @FXML
    private TableView<Aerolinea> tbAerolinea;
    @FXML
    private TableColumn<Aerolinea, Integer> tbcIdAerolinea;
    @FXML
    private TableColumn<Aerolinea, String> tbcNombre;
    @FXML
    private TableColumn<Aerolinea, String> tbcFMod;
    @FXML
    private TableColumn<Aerolinea, String> tbcModP;
    @FXML
    private TextField txtBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnNuevo;
    public ObservableList<Aerolinea> data = FXCollections.observableArrayList();
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        rellenarTabla();
    }    

    @FXML
    private void Buscar(ActionEvent event) {
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `aerolineas` WHERE nombre = '" + txtBuscar.getText() + "'";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Aerolinea a1 = new Aerolinea(r1.getString("nombre"),r1.getString("lastUpdate"),r1.getString("lastUpdateBy"));
                a1.setIdAerolinea(r1.getInt("idaerolineas"));
                data.add(a1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
        }
    }

    @FXML
    private void Nuevo(ActionEvent event) {
        AerolineaFacade.setEstado("Agregar");
        RegistrarAerolineaLaunch ral = new RegistrarAerolineaLaunch();
        ral.launch();
        AerolineaListLaunch all1 = new AerolineaListLaunch();
        all1.close();
    }

    @FXML
    private void regresar(ActionEvent event) {
        AdministradorLaunch al1 = new AdministradorLaunch();
        al1.launch();
        AerolineaListLaunch all1 = new AerolineaListLaunch();
        all1.close();
    }
    
    //Inicializando la tabla par poder llenarla
    private void setTable(){
        tbcIdAerolinea.setCellValueFactory(new PropertyValueFactory<>("idAerolinea"));
        tbcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbcFMod.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        tbcModP.setCellValueFactory(new PropertyValueFactory<>("lastUpdateBy"));
        tbAerolinea.setItems(data);
    }
    
    private void rellenarTabla(){
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `aerolineas`";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Aerolinea a1 = new Aerolinea(r1.getString("nombre"),r1.getString("lastUpdate"),r1.getString("lastUpdateBy"));
                a1.setIdAerolinea(r1.getInt("idaerolineas"));
                data.add(a1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
        }
    }

    @FXML
    private void opciones(ContextMenuEvent event) {
        ContextMenu menu = new ContextMenu();
        MenuItem itemEditar =new MenuItem("Editar");
        MenuItem itemEliminar = new MenuItem("Eliminar");
        MenuItem itemActualizar = new MenuItem("Actualizar");
        
        itemEditar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Aerolinea aerolinea= new Aerolinea();
                    aerolinea = tbAerolinea.getSelectionModel().getSelectedItem();
                    AerolineaFacade.setAerolinea(aerolinea);
                    AerolineaFacade.setEstado("Editar");
                    RegistrarAerolineaLaunch ral = new RegistrarAerolineaLaunch();
                    ral.launch();
                    AerolineaListLaunch all1 = new AerolineaListLaunch();
                    all1.close();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al editar");
                }
            }
        });
        menu.getItems().add(itemEditar);
        itemEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Aerolinea aerolinea= new Aerolinea();
                aerolinea = tbAerolinea.getSelectionModel().getSelectedItem();
                aerolinea.delete();
            }
        });
        menu.getItems().add(itemEliminar);
        
        itemActualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rellenarTabla();
                setTable();
            }
        });
        menu.getItems().add(itemActualizar);
        tbAerolinea.setContextMenu(menu);
    }
}
