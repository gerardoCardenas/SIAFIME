
package controladores;

import entidades.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
* @author Gerardo
    Fecha: 28/10/2017.
    Se hace la conexion a la base de datos.
    Copyright Sia.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tbxUsuario;
    @FXML
    private PasswordField tbxContraseña;
    @FXML
    private Button btnLogin;

    /**
     
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void Login(ActionEvent event) {
        Usuario s1 = new Usuario();
        s1.Login(tbxUsuario.getText(), tbxContraseña.getText());
        
    }
    public void setTextField(){
        
        
    }
}
