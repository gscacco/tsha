/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controllers;

import engine.TshaEventBus;
import engine.managers.DBManager;
import exceptions.DataNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import reports.CommandReport;

/**
 * FXML Controller class
 *
 * @author Mirko
 */
public class LoginPanelViewController implements Initializable {

    @FXML
    private TshaTextFieldControl userName;
    @FXML
    private TshaPasswordFieldControl passWord;
    @FXML
    private Button login;
    @FXML
    private Button shutDown;
    @FXML
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userName.setLabelText("User Name");
        passWord.setLabelText("Password");
        login.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (validate(userName.getTextField().getText(), passWord.getPasswordField().getText())) {
                    root.getScene().getWindow().hide();
                } else {
                    //TODO: show a dialog

                }

            }
        });

        shutDown.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                root.getScene().getWindow().hide();
            }
        });

        userName.getTextField().addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                if (checkUserNameValidity(((TextField) event.getSource()).getText())) {
                    System.out.println("INPUT OK");
                } else {
                    System.out.println("INPUT ERROR");
                    TshaEventBus.getInstance().post(new CommandReport(new Stage(),"Characters not allowed"));
               }
            }
        });

        passWord.getPasswordField().addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                if (checkPassWordValidity(((PasswordField) event.getSource()).getText())) {
                    System.out.println("PASSWORD OK");
                } else {
                    System.out.println("PASSWORD ERROR");
                   
                }
            }
        });

    }

    public boolean checkUserNameValidity(String input) {

        return input.matches("^[A-Za-z](?:_?[A-Za-z0-9])*$") && input.length() > 5 && input.length() < 14;
    }

    public boolean checkPassWordValidity(String input) {

        return input.matches("[A-Za-z0-9_\\$\\&]*$") && input.length() >= 8 && input.length() <= 16;
    }

    public boolean validate(String userName, String pwd) {

        try {
            //call db manager retrieve method
            DBManager.getInstance().retrieveUserFromDatabase(userName, pwd);
            return true;
        } catch (DataNotFoundException ex) {
            Logger.getLogger(LoginPanelViewController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
