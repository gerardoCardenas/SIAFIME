/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzadores;

import db.Sesion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo Cardenas
 */
public class UsuarioListLaunch {
    public static Stage stage;
    public void launch(){
        try {
            stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/UsuarioList.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.close();
            stage.setTitle("Usuarios");
            stage.setScene(new Scene(root1));  
            stage.show();
            stage.centerOnScreen();
            stage.setResizable(false);
            Sesion s1 = new Sesion();
            JOptionPane.showMessageDialog(null, s1.obtenerUsuario());
        } catch (Exception e) {
        }
    }
    public void close(){
        stage.close();
        stage = new Stage();
    }
    
}
