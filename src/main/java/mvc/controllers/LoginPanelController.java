/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controllers;

import domain.User;
import engine.TshaEventBus;
import event.data.IExchangeData;
import event.data.KeyTypedData;
import event.data.LoginData;
import event.data.ShutDownData;
import exceptions.DataNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.model.LoginPanelModel;
import reports.CommandReport;

/**
 *
 * @author mpanagrosso
 */
public class LoginPanelController extends BaseController{

    private static LoginPanelController instance = null;

    FXMLLoader loader = null;
    LoginPanelModel model;
    public static String INVALID_CREDENTIALS = "Invalid Credentials";
    private HashMap<String, User> users = new HashMap<>();

    private LoginPanelController() throws MalformedURLException, IOException {
        stage = new Stage();
        java.nio.file.Path path = Paths.get("");
        System.out.println("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\components\\LoginPanelView.fxml");
        loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\components\\LoginPanelView.fxml"));
        loader.setRoot(new AnchorPane());
        loader.load();
        model = loader.getController();
        users = populateAccounts();
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

    public void showView(Stage primaryStage) {
        Scene scene = new Scene(loader.getRoot());
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

    @Override
    public void changed(ObservableValue<? extends IExchangeData> ov, IExchangeData t, IExchangeData t1) {
        if (ov.getValue() instanceof LoginData) {
            if (validate(((LoginData) ov.getValue()).getUserName(), ((LoginData) ov.getValue()).getPassWord())) {
                hideView();
                initialize();
            } else {
                TshaEventBus.getInstance().post(new CommandReport(stage.getScene().getWindow(), INVALID_CREDENTIALS, 1));
//                model.setUserName("");
                model.setPassword("");
            }
        } else if (ov.getValue() instanceof ShutDownData) {
            hideView();
            initialize();

        } else if (ov.getValue() instanceof KeyTypedData && ((KeyTypedData) ov.getValue()).getCaller().equals("userField")) {
            if (checkUserNameValidity(((KeyTypedData) ov.getValue()).getKeyTyped())) {

                System.out.println("INPUT OK");
            } else {
                System.out.println("INPUT ERROR");
            }

        } else if (ov.getValue() instanceof KeyTypedData && ((KeyTypedData) ov.getValue()).getCaller().equals("passwordField")) {
            if (checkPassWordValidity(((KeyTypedData) ov.getValue()).getKeyTyped())) {

                System.out.println("PASSWORD OK");
            } else {
                System.out.println("PASSWORD ERROR");
            }
        }

    }

    public boolean validate(String user, String pwd) {

        try {
            //call account manager retrieve method
            retrieveUserFromDatabase(user, pwd);
            return true;
        } catch (DataNotFoundException ex) {
            Logger.getLogger(LoginPanelModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean checkUserNameValidity(String input) {

        return input.matches("^[A-Za-z](?:_?[A-Za-z0-9])*$") && input.length() > 4 && input.length() < 14;
    }

    public boolean checkPassWordValidity(String input) {

        return input.matches("[A-Za-z0-9_\\$\\&]*$") && input.length() >= 8 && input.length() <= 16;
    }

    private HashMap<String, User> populateAccounts() {
        HashMap<String, User> result = new HashMap<>();
        result.put("Pippo", new User("Pippo", "Password1", "Pippo di Topolinia"));
        result.put("Pluto", new User("Pluto", "Password2", "Pluto di Topolinia"));
        result.put("Paperino", new User("Paperino", "Password3", "Paperino di Paperopoli"));
        result.put("Paperone", new User("Paperone", "Password1", "Paperone di Paperopoli"));
        result.put("QuiQuoQua", new User("QuiQuoQua", "Password1", "QuiQuoQua di Paperopoli"));
        return result;
    }

    public User retrieveUserFromDatabase(String userName, String pwd) throws DataNotFoundException {
        //STUB CODE

        if (users.containsKey(userName) && users.get(userName).getPassWord().equals(pwd)) {
            return users.get(userName);
        } else {
            throw new DataNotFoundException();
        }
    }
}
