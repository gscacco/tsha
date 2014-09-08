package mvc.model;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import mvc.controllers.LoginPanelController;
import mvc.controllers.TshaPasswordFieldControl;
import mvc.controllers.TshaTextFieldControl;

/**
 *
 * @author Mirko
 */
public class LoginPanelModel implements Initializable {

    // Model 
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LoginPanelController.getInstance().login();
            }
        });

        shutDown.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LoginPanelController.getInstance().shutDown();
            }
        });

        userName.getTextField().addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (checkUserNameValidity(userName.getTextField().getText())) {

                    System.out.println("INPUT OK");
                } else {
                    System.out.println("INPUT ERROR");
                }
            }
        });
        
             passWord.getPasswordField().addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (checkPassWordValidity(passWord.getPasswordField().getText())) {

                    System.out.println("INPUT OK");
                } else {
                    System.out.println("INPUT ERROR");
                }
            }
        });


    }

    public void setUserNameText(String value) {
        userName.setLabelText(value);
    }

    public void setPasswordText(String value) {
        passWord.setLabelText(value);
    }

    public void setUserName(String value) {
        userName.getTextField().setText(value);
    }

    public void setPassword(String value) {
        passWord.getPasswordField().setText(value);
    }

    public String getUserName() {
        return userName.getTextField().getText();
    }

    public String getPassword() {
        return passWord.getPasswordField().getText();
    }

    public boolean checkUserNameValidity(String input) {

        return input.matches("^[A-Za-z](?:_?[A-Za-z0-9])*$") && input.length() > 4 && input.length() < 14;
    }

    public boolean checkPassWordValidity(String input) {

        return input.matches("[A-Za-z0-9_\\$\\&]*$") && input.length() >= 8 && input.length() <= 16;
    }

}
