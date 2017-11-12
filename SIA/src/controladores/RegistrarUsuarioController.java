/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import entidades.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import lanzadores.RegistrarUsuarioLaunch;
import lanzadores.UsuarioListLaunch;

/**
 * FXML Controller class
 *
 * @author Gerardo Cardenas
 */
public class RegistrarUsuarioController implements Initializable {

    @FXML
    private Pane pie;
    @FXML
    private TextField nombreUser;
    @FXML
    private TextField contraceñauser;
    @FXML
    private ComboBox<String> tipouser;
    @FXML
    private Button btnAgregar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarCombo();
    }   
    private void rellenarCombo(){
        tipouser.getItems().addAll("Administrador" , "Empleado", "Cliente" );
    }

    @FXML
    private void salir(ActionEvent event) {
        UsuarioListLaunch ull = new UsuarioListLaunch();
        ull.launch();
        RegistrarUsuarioLaunch rul = new RegistrarUsuarioLaunch();
        rul.close();
    }

    @FXML
    private void guardar(ActionEvent event) {
        Usuario u = new Usuario();
        u.setUsuario(nombreUser.getText());
        u.setContraseña(contraceñauser.getText());
        u.setTipoUsuario(tipouser.getValue());
        try {
            u.insert();
            UsuarioListLaunch ull = new UsuarioListLaunch();
            ull.launch();
            RegistrarUsuarioLaunch rul = new RegistrarUsuarioLaunch();
            rul.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el llenado de Datos");
        }
    }
    
}
