/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Aerolinea;
import facade.AerolineaFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lanzadores.AerolineaListLaunch;
import lanzadores.RegistrarAerolineaLaunch;
import lanzadores.UsuarioListLaunch;

/**
 * FXML Controller class
 *
 * @author emmanuel
 */
public class RegistrarAerolineaController implements Initializable {

    @FXML
    private TextField txfNomAero;
    @FXML
    private Button btnAgregar;
    @FXML
    private Label lbEtiqueta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(AerolineaFacade.getEstado().equals("Agregar")){
            lbEtiqueta.setText("Agregue una Aerolinea");
            txfNomAero.setText("");
            btnAgregar.setText("Agregar");
        }
        else{
            lbEtiqueta.setText("Edite una Aerolinea");
            txfNomAero.setText(AerolineaFacade.getAerolinea().getNombre());
            btnAgregar.setText("Editar");
        }
    }    

    @FXML
    private void regresar(ActionEvent event) {
        AerolineaListLaunch ull = new AerolineaListLaunch();
        ull.launch();
        RegistrarAerolineaLaunch ral = new RegistrarAerolineaLaunch();
        ral.close();
    }

    @FXML
    private void btnGuardar(ActionEvent event) {
       Aerolinea a = new Aerolinea();
       a.setNombre(txfNomAero.getText());
       a.setIdAerolinea(AerolineaFacade.getAerolinea().getIdAerolinea());
       if(AerolineaFacade.getEstado().equals("Agregar")){
           try {
                a.insert();
                AerolineaListLaunch ull = new AerolineaListLaunch();
                ull.launch();
                RegistrarAerolineaLaunch ral = new RegistrarAerolineaLaunch();
                ral.close();
           } catch (Exception e) {
           }
       }
       else{
           try {
                a.update();
                AerolineaListLaunch ull = new AerolineaListLaunch();
                ull.launch();
                RegistrarAerolineaLaunch ral = new RegistrarAerolineaLaunch();
                ral.close();
           } catch (Exception e) {
           }
       }
    }
    
}
