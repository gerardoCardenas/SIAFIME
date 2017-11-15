/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Aerolinea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lanzadores.AdministradorLaunch;
import lanzadores.AerolineaListLaunch;

/**
 * FXML Controller class
 *
 * @author Pablo I
 */
public class AerolineaListController implements Initializable {

    @FXML
    private TableView<Aerolinea> tbAerolinea;
    @FXML
    private TableColumn<Aerolinea, Integer> tbcIdAerolinea;
    @FXML
    private TableColumn<Aerolinea, String> tbcNombre;
    @FXML
    private TableColumn<Aerolinea, String> tbcFMod;
    @FXML
    private TableColumn<Aerolinea, String> tbcModP;
    @FXML
    private TextField txtBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnNuevo;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setTable();
        //rellenar
    }    

    @FXML
    private void Buscar(ActionEvent event) {
    }

    @FXML
    private void Nuevo(ActionEvent event) {
    }

    @FXML
    private void regresar(ActionEvent event) {
        AdministradorLaunch al1 = new AdministradorLaunch();
        al1.launch();
        AerolineaListLaunch all1 = new AerolineaListLaunch();
        all1.close();
    }
    
    //Inicializando la tabla par poder llenarla
    private void setTable(){
        
    }
    
    
}
