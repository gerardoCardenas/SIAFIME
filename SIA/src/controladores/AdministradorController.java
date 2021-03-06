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
import javafx.scene.control.Hyperlink;
import lanzadores.AdministradorLaunch;
import lanzadores.AerolineaListLaunch;
import lanzadores.ClaseListLaunch;
import lanzadores.ClienteListLaunch;
import lanzadores.EscalaListLaunch;
import lanzadores.LoginLaunch;
import lanzadores.OrigenListLaunch;
import lanzadores.PasajeListLaunch;
import lanzadores.UsuarioListLaunch;
import lanzadores.VueloListLaunch;

/**
 * FXML Controller class
 *
 * @author Gerardo Cardenas
 */
public class AdministradorController implements Initializable {

    @FXML
    private Hyperlink hlAerolinea;
    @FXML
    private Hyperlink hlEscala;
    @FXML
    private Hyperlink hlCliente;
    @FXML
    private Hyperlink hypasaje;

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

    @FXML
    private void verAerolineas(ActionEvent event) {
        AerolineaListLaunch all = new AerolineaListLaunch();
        all.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void verEscala(ActionEvent event) {
        EscalaListLaunch ell = new EscalaListLaunch();
        ell.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void verCliente(ActionEvent event) {
        ClienteListLaunch cll = new ClienteListLaunch();
        cll.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    
    }

    @FXML
    private void verDestino(ActionEvent event) {
        OrigenListLaunch oll = new OrigenListLaunch();
        oll.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void mostrarUsuario(ActionEvent event) {
        UsuarioListLaunch ull = new UsuarioListLaunch();
        ull.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void VerPasaje(ActionEvent event) {
        PasajeListLaunch pll = new PasajeListLaunch();
        pll.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void VerVuelos(ActionEvent event) {
        VueloListLaunch vll = new VueloListLaunch();
        vll.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void MostrarCliente(ActionEvent event) {
        ClienteListLaunch cll = new ClienteListLaunch();
        cll.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void MostrarAerolineas(ActionEvent event) {
        AerolineaListLaunch all = new AerolineaListLaunch();
        all.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void MostrarEscala(ActionEvent event) {
        EscalaListLaunch ell = new EscalaListLaunch();
        ell.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void MostrarOrigen(ActionEvent event) {
        OrigenListLaunch oll = new OrigenListLaunch();
        oll.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }

    @FXML
    private void MostrarClase(ActionEvent event) {
        ClaseListLaunch cll = new ClaseListLaunch();
        cll.launch();
        AdministradorLaunch al = new AdministradorLaunch();
        al.close();
    }
}
