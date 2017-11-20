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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gerardo
 */
public class RegistrarClienteController implements Initializable {

    @FXML
    private TextField txfNombre;
    @FXML
    private TextField txfApellidos;
    @FXML
    private TextField txfEdad;
    @FXML
    private TextField txfDireccion;
    @FXML
    private TextField txfCorreo;
    @FXML
    private TextField txfTelefono;
    @FXML
    private Button btnRegistrar;
    @FXML
    private TextField txfPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
