/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lanzadores.EmpleadoLaunch;
import lanzadores.VueloListLaunch;

/**
 * FXML Controller class
 *
 * @author Gerardo Cardenas
 */
public class EmpleadoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verVuelos(ActionEvent event) {
        VueloListLaunch vll = new VueloListLaunch();
        vll.launch();
        EmpleadoLaunch el = new EmpleadoLaunch();
        el.close();
    }

    @FXML
    private void verPromociones(ActionEvent event) {
    }

    @FXML
    private void registrarCliente(ActionEvent event) {
    }

    @FXML
    private void verClientes(ActionEvent event) {
    }
    
}
