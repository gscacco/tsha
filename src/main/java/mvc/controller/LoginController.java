package mvc.controller;

import constants.IPropertyReader;
import mvc.controller.interfaces.BaseController;
import events.SessionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import managers.interfaces.IAccountManager;
import managers.interfaces.ICommunicationManager;
import mvc.controller.interfaces.IService;

/**
 *
 * @author Mirko
 */
public class LoginController extends AnchorPane implements BaseController, IService {

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
    private ICommunicationManager communicationManager;

    public LoginController(IAccountManager accountManager, ICommunicationManager communicationManager, Stage stage, IPropertyReader propertiesReader) {
        this.stage = stage;
        this.accountManager = accountManager;
        this.communicationManager = communicationManager;
        communicationManager.register(this);

        java.nio.file.Path path = Paths.get("");
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + propertiesReader.readProperty("views") + "LoginPanel.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initStage();

    }

    @Override
    public void initStage() {
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
                    moveErrorPanel(80, -60);
                }
            }
        });
        usernameField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (moveErrorPanel.getToY() == 80) {
                    moveErrorPanel(80, -60);
                }
            }
        });

    }

    private void moveErrorPanel(int initialPos, int finalPos) {
        moveErrorPanel.setFromY(initialPos);
        moveErrorPanel.setToY(finalPos);
        moveErrorPanel.play();
    }

    @Override
    public void hideView() {
        this.setVisible(false);
        stage.hide();
    }

    @Override
    public void execute(Stage primaryStage) {
        stage.initOwner(primaryStage);
        stage.show();

    }
    
   @Override
    public void showView(Stage primaryStage) {
        stage.initOwner(primaryStage);
        stage.show();

    }
    public void manageLogin() {

        if (accountManager.checkUserValidity(usernameField.getText(), passwordField.getText())) {
            hideView();
            communicationManager.post(SessionEvent.SESSION_ENTERED);
        } else {
            errorLabel.setText(INVALID_CREDENTIALS);
            moveErrorPanel(-60, 80);
        }
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
