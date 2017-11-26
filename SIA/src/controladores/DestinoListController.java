/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Ciudad;
import entidades.Destino;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gerardo
 */
public class DestinoListController implements Initializable {

    @FXML
    private Hyperlink back;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField txtFCliente;
    @FXML
    private Label lblDestino;
    @FXML
    private TableView<Destino> tvDestino;
    @FXML
    private TableColumn<Destino, Integer> tcId;
    @FXML
    private TableColumn<Destino, String> cbAerolinea;
    @FXML
    private TableColumn<Destino, String> tcCiudad;
    @FXML
    private TableColumn<Destino, String> tcLastUpdate;
    @FXML
    private TableColumn<Destino, String> tcLastUpdateBy;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevo(ActionEvent event) {
    }

    @FXML
    private void buscar(ActionEvent event) {
    }
    
}
