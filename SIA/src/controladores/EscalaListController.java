/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import db.Conexion;
import entidades.Escala;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import lanzadores.AdministradorLaunch;
import lanzadores.EscalaListLaunch;

/**
 * FXML Controller class
 *
 * @author emmanuel
 */
public class EscalaListController implements Initializable {
    
    @FXML
    private TableView<Escala> tabEscala;
    @FXML
    private TableColumn<Escala, Integer> tbidEscala;
    @FXML
    private TableColumn<Escala, String> tbLasUpdate;
    @FXML
    private TableColumn<Escala, String> tbLastUpdateBy;
    @FXML
    private TextField txfBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnNuevo;
    public ObservableList<Escala> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Escala, String> tbDescripcion;
    @FXML
    private Hyperlink linkRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setTable();
        rellenarTabla();
    }
    
    private void Buscar (ActionEvent event){
        data.clear();
        Conexion c1 =new Conexion();
        Connection co = c1.conectar();
        String descrip;
        descrip = txfBuscar.getText();
        String query = "SELECT * FROM `escala` WHERE descripcion = '"+descrip+"'";
        Statement stquery;
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Escala e1 = new Escala(r1.getString("descripcion"));
                e1.setIdEscala(r1.getInt("idescala"));
                e1.setLastUpdate(r1.getString("lastUpdate"));
                e1.setLastUpdateBy(r1.getString("lastUpdateBy"));
                data.add(e1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
        }
    }

    @FXML
    private void regresar(ActionEvent event) {
        AdministradorLaunch al1 = new AdministradorLaunch();
        al1.launch();
        EscalaListLaunch ell = new EscalaListLaunch();
        ell.close();
    }
    
    //inicializo la tabla para poder llenarla
    private void setTable(){
        tbidEscala.setCellValueFactory(new PropertyValueFactory<>("idescala"));
        tbDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tbLasUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        tbLastUpdateBy.setCellValueFactory(new PropertyValueFactory<>("lastUpdateBy"));
        tabEscala.setItems(data);
    }
    private void rellenarTabla(){
        data.clear();
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `escala`";
        Statement stquery;
        try {
            stquery=co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                Escala u1 = new Escala(r1.getString("descripcion"),r1.getString("lastUpdate"),r1.getString("lastUpdateBy"));
                u1.setIdEscala(r1.getInt("idescala"));
                u1.setLastUpdate(r1.getString("lastUpdate"));
                u1.setLastUpdateBy(r1.getString("lastUpdateBy"));                
                data.add(u1);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el relleno de datos"+e);
        }
    }
    
    
}
