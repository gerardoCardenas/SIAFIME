/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    private Button btAgregar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
