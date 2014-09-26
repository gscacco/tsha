/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import mvc.controller.ResourcesReleaser;
import mvc.controller.StartUpGuiController;
import managers.CommmunicationManager;
import constants.IPropertyReader;
import constants.PropertiesReader;
import events.Events;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

import java.awt.Dimension;
import java.net.URL;
import java.nio.file.Paths;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JFrame;
import managers.AccountManager;
import managers.ServiceManager;
import managers.SessionManager;
import mvc.controller.LoginController;
import mvc.controller.TshaMainBarController;
import mvc.view.TshaJFrame;

/**
 *
 * @author mpanagrosso
 */
public class TshaApplication extends Application {

    private static Stage primaryStage;
    private static TshaJFrame frame;

    private SessionManager sessionManager;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        //MANAGERS//
        AccountManager accountManager = new AccountManager();
        CommmunicationManager communicationManager = new CommmunicationManager();
        ServiceManager serviceManager = new ServiceManager();

        IPropertyReader propertiesReader = new PropertiesReader();

        //primary stage settings
        Group primaryGroup = new Group();
        int screenOffset = 5;
        Scene primaryScene = new Scene(primaryGroup, Integer.parseInt(propertiesReader.readProperty("width")) - screenOffset,
                Integer.parseInt(propertiesReader.readProperty("height")), Color.DARKGRAY);
                
        primaryStage.setY(0);
        primaryStage.setX(0);
        primaryStage.setScene(primaryScene);
        primaryStage.initStyle(StageStyle.UTILITY);

        primaryStage.show();
        //Services
        ResourcesReleaser releaser = new ResourcesReleaser(communicationManager);

        //Scene Objects
        frame = new TshaJFrame(new WorldWindowGLCanvas());
        TshaMainBarController mainBar = new TshaMainBarController(primaryStage, new Stage(), communicationManager, propertiesReader);

        StartUpGuiController startUpGuiController = new StartUpGuiController(primaryStage, frame, mainBar,
                new Dimension(Integer.parseInt(propertiesReader.readProperty("width")),
                        Integer.parseInt(propertiesReader.readProperty("height"))));

        serviceManager.register(Events.SESSION_ENTERED, startUpGuiController);

        releaser.register(startUpGuiController);

        LoginController loginController = new LoginController(accountManager, communicationManager, primaryStage, new Stage(), propertiesReader);
        serviceManager.register(Events.SESSION_WAITING_LOGIN, loginController);

        serviceManager.register(Events.SESSION_EXITED, releaser);

        sessionManager = new SessionManager(primaryStage, communicationManager, serviceManager);

    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        launch(args);

    }

}
