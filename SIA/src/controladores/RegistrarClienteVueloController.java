/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Sesion;
import entidades.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;
import lanzadores.ClienteListLaunch;
import lanzadores.EmpleadoLaunch;
import lanzadores.RegistrarClienteLaunch;
import lanzadores.RegistrarClienteVueloLaunch;
import sia.Reservacion;

/**
 * FXML Controller class
 *
 * @author Gerardo
 */
public class RegistrarClienteVueloController implements Initializable {

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
    private Hyperlink back;
    @FXML
    private RadioButton rbtnF;
    @FXML
    private ToggleGroup Gen;
    @FXML
    private RadioButton rbtnM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardar(ActionEvent event) {
        Cliente c = new Cliente();
        c.setNombre(txfNombre.getText());
        c.setApellido(txfApellidos.getText());
        c.setEdad(Integer.parseInt(txfEdad.getText()));
        if(rbtnF.isSelected()){
            c.setGenero("F");
        }else if(rbtnM.isSelected()){
            c.setGenero("M");
        }
        c.setTelefono(txfTelefono.getText());
        c.setDireccion(txfDireccion.getText());
        c.setEmail(txfCorreo.getText());
        
        try{
            c.setIdCliente(c.registrarClienteVuelo());
            
            Reservacion.setCliente(c);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en el llenado de datos");
        }
            JOptionPane.showMessageDialog(null, "El vuelo se reservo correctamente, su numero de vuelo es: " + Reservacion.reservar());
            EmpleadoLaunch cll = new EmpleadoLaunch();
            cll.launch();
            RegistrarClienteVueloLaunch rcl = new RegistrarClienteVueloLaunch();
            rcl.close();
    }

    @FXML
    private void salir(ActionEvent event) {
    }
    
}
