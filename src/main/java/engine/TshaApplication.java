/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import engine.managers.SessionManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mirko
 *
 */
public class TshaApplication extends Application {
Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new Group()));
//        stage.setFullScreen(true);
        stage.show();
        
        SessionManager sessionManager = new SessionManager(stage);
        sessionManager.manageUserLogin();
        primaryStage = stage;
    }

    
    
   public Stage getPrimaryStage(){
    return this.primaryStage;}
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
