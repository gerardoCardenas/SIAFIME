/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Conexion;
import entidades.Cliente;
import facade.ClienteFacade;
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
import lanzadores.ClienteListLaunch;
import lanzadores.RegistrarClienteLaunch;
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
    @FXML
    private TableColumn<Cliente, String> tbClmApellido;
    @FXML
    private TableColumn<Cliente, String> tbClmGenero;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       setTable();
       rellenarTabla();
    }    

    @FXML
    private void nuevo(ActionEvent event) {
        ClienteFacade.setEstado("Agregar");
        RegistrarClienteLaunch rcl = new RegistrarClienteLaunch();
        rcl.launch();
        ClienteListLaunch cll = new ClienteListLaunch();
        cll.close();
    }
    
    @FXML
    private void buscar(ActionEvent event) {
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String nombre;
        nombre = txtFCliente.getText();
        String query = "SELECT * FROM `cliente` WHERE nombre = '"+nombre+"'";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Cliente c = new Cliente(r1.getString("nombre"),
                        r1.getString("apellido"), r1.getInt("edad"),
                        r1.getString("genero"), r1.getString("telefono"), 
                        r1.getString("direccion"), r1.getString("email"), 
                        r1.getString("lastUpdate"), r1.getString("lastUpdateBy"));
                c.setIdCliente(r1.getInt("idCliente"));
                c.setLastUpdate(r1.getString("lastUpdate"));
                c.setLastUpdateBy(r1.getString("lastUpdateBy"));
                data.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
        }
    }
    
    @FXML
    private void regresar(ActionEvent event) {
        AdministradorLaunch al1 = new AdministradorLaunch();
        al1.launch();
        ClienteListLaunch cll = new ClienteListLaunch();
        cll.close();
    }
    
    private void setTable(){
        tbClmNCli.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        tbClmNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbClmApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tbClmEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tbClmGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tbClmTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tbClmDir.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tbClmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbClmLastU.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        tbClmLastUBy.setCellValueFactory(new PropertyValueFactory<>("lastUpdateBy"));
        tvCliente.setItems(data);
    }
    
    private void rellenarTabla(){
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `cliente`";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Cliente c = new Cliente(r1.getString("nombre"),
                        r1.getString("apellido"), r1.getInt("edad"),
                        r1.getString("genero"), r1.getString("telefono"), 
                        r1.getString("direccion"), r1.getString("email"), 
                        r1.getString("lastUpdate"), r1.getString("lastUpdateBy"));
                c.setIdCliente(r1.getInt("idCliente"));
                c.setLastUpdate(r1.getString("lastUpdate"));
                c.setLastUpdateBy(r1.getString("lastUpdateBy"));
                data.add(c);
                }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
        }
    }
    
    //Hacer la opcion para editar o eliminar Algun registro
    @FXML
    private void opcionesUsuario(ContextMenuEvent event) {
        ContextMenu menu = new ContextMenu();
        MenuItem itemEditar =new MenuItem("Editar");
        MenuItem itemEliminar = new MenuItem("Eliminar");
        MenuItem itemActualizar = new MenuItem("Actualizar");
        itemEditar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Cliente c = tvCliente.getSelectionModel().getSelectedItem();
                ClienteFacade.setCliente(c);
                ClienteFacade.setEstado("Editar");
                RegistrarClienteLaunch rcl3 = new RegistrarClienteLaunch();
                rcl3.launch();
                ClienteListLaunch cll = new ClienteListLaunch();
                cll.close();
            }
        });
        menu.getItems().add(itemEditar);
        tvCliente.setContextMenu(menu);
        itemEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Cliente s = new Cliente();
                s = tvCliente.getSelectionModel().getSelectedItem();
                s.delete();
                data.clear();
                rellenarTabla();
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
        tvCliente.setContextMenu(menu);
    }
    
}
