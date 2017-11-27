/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Escala;
import facade.EscalaFecade;
import java.net.URL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import lanzadores.EscalaListLaunch;
import lanzadores.RegistrarEscalaLaunch;


/**
 * FXML Controller class
 *
 * @author Pablo I
 */
public class RegistrarEscalaController implements Initializable {

    @FXML
    private Label lblEnc;
    @FXML
    private TextField txfNEsc;
    @FXML
    private Button btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Escala e = new Escala();
       if(EscalaFecade.getEstado().equals("Agregar")){
            btnGuardar.setText("Agregar");
            lblEnc.setText("Agregar un usuario");
            txfNEsc.setText("");
        }
        else{
            btnGuardar.setText("Editar");
            lblEnc.setText("Editar un usuario");
            txfNEsc.setText(EscalaFecade.getUsuario().getDescripcion());
       }
    }

    @FXML
    private void salir(ActionEvent event) {
        EscalaListLaunch ull = new EscalaListLaunch();
        ull.launch();
        RegistrarEscalaLaunch rul = new RegistrarEscalaLaunch();
        rul.close();
    }
    
    @FXML
    private void guardar(ActionEvent event) {
        Escala e = new Escala();
        e.setDescripcion(txfNEsc.getText());
        if(btnGuardar.getText().equals("Agregar")){
        try {
            e.insert();
            EscalaListLaunch ell = new EscalaListLaunch();
            ell.launch();
            RegistrarEscalaLaunch rel = new RegistrarEscalaLaunch();
            rel.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en el llenado de Datos");
        }
        }else{
            e.setIdEscala(EscalaFecade.getUsuario().getIdEscala());
            e.update();           
            EscalaListLaunch ell = new EscalaListLaunch();
            ell.launch();
            RegistrarEscalaLaunch rel = new RegistrarEscalaLaunch();
            rel.close();
        }
    }

    /*    public Button getBtnAgregar() {
        return btnAgregar;
    }

    public Label getLbEncabezado() {
        return lbEncabezado;
    }*/

}
