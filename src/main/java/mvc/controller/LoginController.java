package mvc.controller;

import constants.IPropertyReader;
import engine.TshaApplication;
import mvc.controller.interfaces.BaseController;
import events.Events;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
    private Stage primaryStage;
    private double errorPanelHeight;
    private final double errorPanePositionOffset = 20.0;

    @FXML
    private Button login;
    @FXML
    private Button shutDownButton;
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

    public LoginController(IAccountManager accountManager, ICommunicationManager communicationManager, Stage primaryStage, Stage stage, IPropertyReader propertiesReader) {
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.accountManager = accountManager;
        this.communicationManager = communicationManager;
        communicationManager.register(this);

        java.nio.file.Path path = Paths.get("");
        FXMLLoader loader;
        try {
   //         loader = new FXMLLoader(new URL("file:/" + path.toAbsolutePath().toString() + propertiesReader.readProperty("views") + "LoginPanel.fxml"));
           loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/LoginPanel.fxml"));

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

        errorPanelHeight = errorPanel.getPrefHeight();

        Scene scene = new Scene(this);
        stage.initStyle(StageStyle.TRANSPARENT);

        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setResizable(false);

        stage.centerOnScreen();
        stage.initOwner(primaryStage);
        moveErrorPanel = new TranslateTransition(Duration.seconds(0.5), errorPanel);
        login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                manageLogin();
            }
        });

        shutDownButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        passwordField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (moveErrorPanel.getToY() == errorPanelHeight + errorPanePositionOffset) {
                    moveErrorPanel(errorPanelHeight + errorPanePositionOffset, -errorPanelHeight);
                }
            }
        });
        usernameField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (moveErrorPanel.getToY() == errorPanelHeight + errorPanePositionOffset) {
                    moveErrorPanel(errorPanelHeight + errorPanePositionOffset, -errorPanelHeight);
                }
            }
        });

    }

    private void moveErrorPanel(double initialPos, double finalPos) {
        moveErrorPanel.setFromY(initialPos);
        moveErrorPanel.setToY(finalPos);
        moveErrorPanel.play();
    }

    @Override
    public void hideView() {
        this.setVisible(false);
        stage.hide();
        usernameField.setText("");
        passwordField.setText("");
    }

    @Override
    public void showView() {
        this.setVisible(true);
        stage.show();

    }

    public void manageLogin() {

        if (accountManager.checkUserValidity(usernameField.getText(), passwordField.getText())) {
            hideView();
            communicationManager.post(Events.SESSION_ENTERED);
        } else {
            errorLabel.setText(INVALID_CREDENTIALS);
            moveErrorPanel(-errorPanelHeight, errorPanelHeight + errorPanePositionOffset);
        }
    }

    @Override
    public void execute() {
        showView();
    }

    @Override
    public void release() {
        hideView();
        usernameField.setText("");
        passwordField.setText("");
    }

}
