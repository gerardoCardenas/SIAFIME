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
import lanzadores.AdministradorLaunch;
import lanzadores.LoginLaunch;
import lanzadores.UsuarioListLaunch;

/**
 * FXML Controller class
 *
 * @author Gerardo Cardenas
 */
public class AdministradorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void verUsuarios(ActionEvent event) {
        UsuarioListLaunch ull = new UsuarioListLaunch();
        ull.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }
    @FXML
    private void salir(ActionEvent event) {
        LoginLaunch ll1 = new LoginLaunch();
        ll1.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
        LoginController l1 = new LoginController();
        l1.setTextField();
    }
}
