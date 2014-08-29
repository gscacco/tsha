/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Mirko
 */
public class SessionManager {
    private Stage primaryStage;

    
    public SessionManager(Stage primaryStage){
    this.primaryStage = primaryStage;
    }
    public void manageUserLogin(){
        try {
            Stage stage = new Stage();
            java.nio.file.Path path = Paths.get("");
            System.out.println("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\components\\LoginPanelView.fxml");
            FXMLLoader loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\components\\LoginPanelView.fxml"));
            loader.setRoot(new AnchorPane());
            loader.load();
            Scene scene = new Scene(loader.getRoot());
            stage.setScene(scene);
            stage.initOwner(primaryStage);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.centerOnScreen();
            stage.show();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
    }
}
