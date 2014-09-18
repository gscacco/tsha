/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mvc.model.LoginModel;

/**
 *
 * @author mpanagrosso
 */
public class LoginController {

    private static LoginController instance = null;
    private static Stage stage;

    public void hideView() {
        stage.hide();
    }
    private LoginModel model;

    private LoginController() {
        stage = new Stage();
        model = new LoginModel();
        setUpLoginStage();

    }

    private void setUpLoginStage() {
        Scene scene = new Scene(model);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
    }

    public static LoginController getInstance() {

        if (instance == null) {

            instance = new LoginController();

        }
        return instance;
    }

    public void showView(Stage primaryStage) {

        stage.initOwner(primaryStage);

        stage.show();

    }

    public static Stage getStage() {
        return stage;
    }

    public Parent getModel() {
        return model;
    }

    public void manageLogin() {
        if (model.getUsernameField().getText().equals("Utente1")
                && model.getPasswordField().getText().equals("Password1")) {
            hideView();
        }
    }

}
