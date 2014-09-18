/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import mvc.controller.LoginController;

/**
 *
 * @author mpanagrosso
 */
public class TshaApplication extends Application{
    
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
       
        primaryStage.show();
        LoginController.getInstance().showView(primaryStage);

    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);

    }
    
}
