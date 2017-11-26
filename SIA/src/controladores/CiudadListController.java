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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

/**
 * FXML Controller class
 *
 * @author Gerardo
 */
public class CiudadListController implements Initializable {

    @FXML
    private TableView<?> tbAerolinea;
    @FXML
    private TableColumn<?, ?> tbcIdAerolinea;
    @FXML
    private TableColumn<?, ?> tbcNombre;
    @FXML
    private TableColumn<?, ?> tbcFMod;
    @FXML
    private TableColumn<?, ?> tbcModP;
    @FXML
    private TextField txtBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnNuevo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void opciones(ContextMenuEvent event) {
    }

    @FXML
    private void Buscar(ActionEvent event) {
    }

    @FXML
    private void Nuevo(ActionEvent event) {
    }

    @FXML
    private void regresar(ActionEvent event) {
    }
    
}
