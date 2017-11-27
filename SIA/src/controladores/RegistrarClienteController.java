/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Cliente;
import facade.ClienteFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;
import lanzadores.ClienteListLaunch;
import lanzadores.RegistrarClienteLaunch;

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
    private Hyperlink back;
    @FXML
    private RadioButton rbtnF;
    @FXML
    private ToggleGroup Gen;
    @FXML
    private RadioButton rbtnM;
    @FXML
    private Label lvlEnc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Cliente c = new Cliente();
        if(ClienteFacade.getEstado().equals("Registrar")){
            btnRegistrar.setText("Registrar");
            lvlEnc.setText("Registrarse como Cliente");
            txfNombre.setText("");
            txfApellidos.setText("");
            txfEdad.setText("");
            rbtnF.setSelected(true);
            txfTelefono.setText("");
            txfDireccion.setText("");
            txfCorreo.setText("");
        }else{
            btnRegistrar.setText("Editar");
            lvlEnc.setText("Editar Cliente");
            txfNombre.setText(ClienteFacade.getCliente().getNombre());
            txfApellidos.setText(ClienteFacade.getCliente().getApellido());
            txfEdad.setText(ClienteFacade.getCliente().getEdad()+"");
            if(ClienteFacade.getCliente().getGenero() == "F"){
                rbtnF.setSelected(true);
            }else{
                rbtnM.setSelected(true);
            }
            txfTelefono.setText(ClienteFacade.getCliente().getTelefono());
            txfDireccion.setText(ClienteFacade.getCliente().getDireccion());
            txfCorreo.setText(ClienteFacade.getCliente().getEmail());
        }
    }    

    @FXML
    private void salir(ActionEvent event) {
        ClienteListLaunch cll = new ClienteListLaunch();
        cll.launch();
        RegistrarClienteLaunch rcl = new RegistrarClienteLaunch();
        rcl.close();
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
        if(btnRegistrar.getText().equals("Agregar")){  
            try{
                c.insert();
                ClienteListLaunch cll = new ClienteListLaunch();
                cll.launch();
                RegistrarClienteLaunch rcl = new RegistrarClienteLaunch();
                rcl.close();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error en el llenado de datos");
            }
        }else{
            c.setIdCliente(ClienteFacade.getCliente().getIdCliente());
            c.update();
            ClienteListLaunch cll = new ClienteListLaunch();
            cll.launch();
            RegistrarClienteLaunch rcl = new RegistrarClienteLaunch();
            rcl.close();
        }
    }
}