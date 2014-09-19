package mvc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import managers.AccountManager;
import managers.interfaces.IAccountManager;

/**
 *
 * @author Mirko
 */
public class LoginController extends AnchorPane {

    private Stage stage;
    private static String INVALID_CREDENTIALS = "Invalid credentials";
    private TranslateTransition moveErrorPanel;

    @FXML
    private Button login;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private AnchorPane errorPanel;
    @FXML
    private Label errorLabel;

    private IAccountManager accountManager;

    public LoginController(IAccountManager accountManager) {
        stage = new Stage();
        this.accountManager = accountManager;

        java.nio.file.Path path = Paths.get("");
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\LoginPanel.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setUpLoginStage();

    }

    private void setUpLoginStage() {
        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();

        moveErrorPanel = new TranslateTransition(Duration.seconds(0.5), errorPanel);
        login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                manageLogin();
            }
        });

        passwordField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (moveErrorPanel.getToY() == 80) {
                    moveErrorPanel.setFromY(80);
                    moveErrorPanel.setToY(-60);
                    moveErrorPanel.play();
                }
            }
        });
        usernameField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (moveErrorPanel.getToY() == 80) {
                    moveErrorPanel.setFromY(80);
                    moveErrorPanel.setToY(-60);
                    moveErrorPanel.play();
                }

            }
        });

    }

    public void hideView() {
        this.setVisible(false);
        stage.hide();
    }

    public void showView(Stage primaryStage) {
        stage.initOwner(primaryStage);
        stage.show();

    }

    public void manageLogin() {

        if (accountManager.checkUserValidity(usernameField.getText(), passwordField.getText())) {
            hideView();
        } else {
            errorLabel.setText(INVALID_CREDENTIALS);
            moveErrorPanel.setFromY(-60);
            moveErrorPanel.setToY(80);

            moveErrorPanel.play();
        }
    }

    public Stage getStage() {
        return stage;
    }

}
