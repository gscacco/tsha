package mvc.model;

import engine.TshaEventBus;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import mvc.controllers.LoginPanelController;
import static mvc.controllers.LoginPanelController.INVALID_CREDENTIALS;
import static mvc.controllers.LoginPanelController.INVALID_INPUT;

import mvc.controllers.TshaPasswordFieldControl;
import mvc.controllers.TshaTextFieldControl;
import reports.CommandReport;

/**
 *
 * @author Mirko
 */
public class LoginPanelModel extends AnchorPane implements Initializable {

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

    public LoginPanelModel() {
        java.nio.file.Path path = Paths.get("");
        System.out.println("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\components\\LoginPanelView.fxml");
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\components\\LoginPanelView.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginPanelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(LoginPanelModel.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LoginPanelController.getInstance().manageLogin();
            }
        });

        shutDown.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LoginPanelController.getInstance().manageShutDown();
            }
        });
//        userName.load();
        userName.getTextField().addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (!checkUserNameValidity(userName.getTextField().getText())) {
                               TshaEventBus.getInstance().post(new CommandReport(LoginPanelController.getStage().getScene().getWindow(), INVALID_INPUT, 0));

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

    public Parent getRoot() {
        return this;
    }

}
