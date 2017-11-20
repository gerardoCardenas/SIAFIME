/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Conexion;
import entidades.Cliente;
import facade.UsuarioFacade;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javax.swing.JOptionPane;
import lanzadores.AdministradorLaunch;
import lanzadores.RegistrarUsuarioLaunch;
import lanzadores.UsuarioListLaunch;

/**
 * FXML Controller class
 *
 * @author Pablo I
 */
public class ClienteListController implements Initializable {

    @FXML
    private TextField txtFCliente;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnNuevo;
    @FXML
    private TableView<Cliente> tvCliente;
    @FXML
    private TableColumn<Cliente, Integer> tbClmNCli;
    @FXML
    private TableColumn<Cliente, String> tbClmNombre;
    @FXML
    private TableColumn<Cliente, Integer> tbClmEdad;
    @FXML
    private TableColumn<Cliente, String> tbClmTel;
    @FXML
    private TableColumn<Cliente, String> tbClmDir;
    @FXML
    private TableColumn<Cliente, String> tbClmEmail;
    @FXML
    private TableColumn<Cliente, String> tbClmLastU;
    @FXML
    private TableColumn<Cliente, String> tbClmLastUBy;
    @FXML
    private Hyperlink back;
    
    public ObservableList<Cliente> data = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevo(ActionEvent event) {
        
    }
    
    
}
