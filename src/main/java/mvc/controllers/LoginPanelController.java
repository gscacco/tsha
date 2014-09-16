/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controllers;

import engine.TshaEventBus;
import engine.managers.AccountManager;
import exceptions.DataNotFoundException;
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
import mvc.controllers.interfaces.ILoginController;
import mvc.model.LoginPanelModel;
import reports.CommandReport;
import reports.SessionEvent;

/**
 *
 * @author mpanagrosso
 */
public class LoginPanelController extends BaseController implements ILoginController {

    private static LoginPanelController instance = null;

//   private FXMLLoader loader = null;
   private LoginPanelModel model;
    public static String INVALID_CREDENTIALS = "Invalid Credentials";
    public static String INVALID_INPUT = "Invalid Input";
    private LoginPanelController() throws MalformedURLException, IOException {
        stage = new Stage();
        model = new LoginPanelModel();
//        model = loader.getController();
        model.setUserNameText("User Name");
        model.setPasswordText("Password");

    }

    public static LoginPanelController getInstance() {
        if (instance == null) {
            try {
                instance = new LoginPanelController();
            } catch (IOException ex) {
                Logger.getLogger(LoginPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return instance;
    }

    @Override
    public void manageLogin() {
        if (validate(model.getUserName(), model.getPassword())) {
            hideView();
            initialize();
            TshaEventBus.getInstance().post(SessionEvent.SESSION_ENTERED);
        } else {
            TshaEventBus.getInstance().post(new CommandReport(stage.getScene().getWindow(), INVALID_CREDENTIALS, 0));
            model.setPassword("");
        }
    }

    @Override
    public void manageShutDown() {
        hideView();
        initialize();

    }

    public void showView(Stage primaryStage) {
        Scene scene = new Scene(model.getRoot());
        stage.setScene(scene);
        stage.initOwner(primaryStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void hideView() {
//    stage.getScene().getWindow().hide();
        stage.hide();
    }

    @Override
    public void initialize() {
        model.setUserName("");
        model.setPassword("");
    }

    public boolean validate(String user, String pwd) {

        try {
            //call account manager retrieve method
            AccountManager.getInstance().retrieveUserFromDatabase(user, pwd);
            return true;
        } catch (DataNotFoundException ex) {
            Logger.getLogger(LoginPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
