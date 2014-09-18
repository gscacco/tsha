/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import javafx.application.Application;
import javafx.stage.Stage;
import mvc.controller.LoginController;

/**
 *
 * @author mpanagrosso
 */
public class MockApp extends Application {

    protected static Stage primaryStage;

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("INNER MOCKAPP");
        this.primaryStage = primaryStage;
        primaryStage.show();
//        startSpecifiedComponents();
    }

//       abstract public void  startSpecifiedComponents();
    static Stage getStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
