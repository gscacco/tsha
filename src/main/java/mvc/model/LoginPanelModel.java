package mvc.model;

import event.data.IExchangeData;
import event.data.KeyTypedData;
import event.data.LoginData;
import event.data.ShutDownData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import mvc.controllers.LoginPanelController;
import mvc.controllers.TshaPasswordFieldControl;
import mvc.controllers.TshaTextFieldControl;

/**
 * FXML Controller class
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
                SimpleObjectProperty<LoginData> exchangeData = new SimpleObjectProperty<>(new LoginData());
                exchangeData.addListener(LoginPanelController.getInstance());
                exchangeData.set(new LoginData(userName.getTextField().getText(), passWord.getPasswordField().getText()));
            }
        });

        shutDown.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                SimpleObjectProperty<IExchangeData> exchangeData = new SimpleObjectProperty<>(new ShutDownData());
                exchangeData.addListener(LoginPanelController.getInstance());
                exchangeData.set(new ShutDownData());
            }
        });

        userName.getTextField().addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                SimpleObjectProperty<IExchangeData> exchangeData = new SimpleObjectProperty<>(new KeyTypedData());
                exchangeData.addListener(LoginPanelController.getInstance());
                exchangeData.set(new KeyTypedData(((TextField) event.getSource()).getText(), "userField"));
            }
        });

        passWord.getPasswordField().addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                SimpleObjectProperty<IExchangeData> exchangeData = new SimpleObjectProperty<>(new KeyTypedData());
                exchangeData.addListener(LoginPanelController.getInstance());
                exchangeData.set(new KeyTypedData(((TextField) event.getSource()).getText(), "passwordField"));
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
}
