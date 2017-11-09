/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lanzadores.LoginLaunch;

/**
 *
 * @author Gerardo
 */
public class SIA extends Application {
    
    Stage stage2;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Estatico.fxml"));
        Scene scene = new Scene(root);
        stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setTitle("Bienvenido al Sistema Internacional De Aeropuertos(S.I.A)");
        LoginLaunch l1 = new LoginLaunch();
        l1.launch();
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void ocultar(){
        stage2.hide();
    }
    public void ver(){
        stage2.show();
    }
    
}
