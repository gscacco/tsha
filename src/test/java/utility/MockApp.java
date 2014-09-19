/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import javafx.application.Application;
import javafx.stage.Stage;
import mvc.controller.LoginController;

/**
 *
 * @author mpanagrosso
 */
public abstract class MockApp extends Application {

    protected static Stage primaryStage;

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.show();
        startSpecifiedComponents();
    }

    abstract public void startSpecifiedComponents();

    public static Stage getStage() {
        return primaryStage;
    }

}
