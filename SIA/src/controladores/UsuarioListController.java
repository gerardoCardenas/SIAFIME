package controladores;

import db.Conexion;
import entidades.Usuario;
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
 * @author Gerardo Cardenas
 */
public class UsuarioListController implements Initializable {

    @FXML
    private TableView<Usuario> tvUsuario;
    @FXML
    private TableColumn<Usuario, Integer> tbId;
    @FXML
    private TableColumn<Usuario, String> tbUsuario;
    @FXML
    private TableColumn<Usuario, String> tbContraseña;
    @FXML
    private TableColumn<Usuario, String> TbTipo;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField tbxUsuario;
    public ObservableList<Usuario> data = FXCollections.observableArrayList();// Se usa esta coleccion para poder manipular los datos
    @FXML
    private TableColumn<Usuario, String> cbLastUpdate;
    @FXML
    private TableColumn<Usuario, String> cbLastUpdateBy;
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
        UsuarioFacade.setEstado("Agregar");
        RegistrarUsuarioLaunch rul = new RegistrarUsuarioLaunch();
        rul.launch();
        UsuarioListLaunch ull = new UsuarioListLaunch();
        ull.close();
    }

    @FXML
    private void buscar(ActionEvent event) {
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String user;
        user = tbxUsuario.getText();
        String query = "SELECT * FROM `usuarios` WHERE Usuario = '"+user+"'";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Usuario u1 = new Usuario(r1.getString("Usuario"),r1.getString("Contraseña"), r1.getString("TipoUsuario"));
                u1.setIdUsuario(r1.getInt("idUsuario"));
                u1.setLastUpdate(r1.getString("lastUpdate"));
                u1.setLastUpdateBy(r1.getString("lastUpdateBy"));
                data.add(u1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
        }
    }

    @FXML
    private void regresar(ActionEvent event) {
        AdministradorLaunch al1 = new AdministradorLaunch();
        al1.launch();
        UsuarioListLaunch ull1 = new UsuarioListLaunch();
        ull1.close();
    }
    //Inicializo la tabla para poderla llenar
    private void setTable(){
        tbId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        tbUsuario.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
        tbContraseña.setCellValueFactory(new PropertyValueFactory<>("Contraseña"));
        TbTipo.setCellValueFactory(new PropertyValueFactory<>("TipoUsuario"));
        cbLastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        cbLastUpdateBy.setCellValueFactory(new PropertyValueFactory<>("lastUpdateBy"));
        tvUsuario.setItems(data);
    }
    private void rellenarTabla(){
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `usuarios`";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Usuario u1 = new Usuario(r1.getString("Usuario"),r1.getString("Contraseña"), r1.getString("TipoUsuario"));
                u1.setIdUsuario(r1.getInt("idUsuario"));
                u1.setLastUpdate(r1.getString("lastUpdate"));
                u1.setLastUpdateBy(r1.getString("lastUpdateBy"));
                data.add(u1);
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
                Usuario usuario = tvUsuario.getSelectionModel().getSelectedItem();
                UsuarioFacade.setUsuario(usuario);
                UsuarioFacade.setEstado("Editar");
                RegistrarUsuarioLaunch rul3 = new RegistrarUsuarioLaunch();
                rul3.launch();
                UsuarioListLaunch ull = new UsuarioListLaunch();
                ull.close();
                
            }
        });
        menu.getItems().add(itemEditar);
        tvUsuario.setContextMenu(menu);
        itemEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Usuario s = new Usuario();
                s = tvUsuario.getSelectionModel().getSelectedItem();
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
        tvUsuario.setContextMenu(menu);
    }
    
}
