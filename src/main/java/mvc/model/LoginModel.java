package mvc.model;

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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mvc.controller.LoginController;

/**
 *
 * @author Mirko
 */
public class LoginModel extends AnchorPane implements Initializable {

    @FXML
    private Button login;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public LoginModel() {
        java.nio.file.Path path = Paths.get("");
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\LoginPanel.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LoginController.getInstance().manageLogin();
            }
        });

    }

        

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }
    
}
