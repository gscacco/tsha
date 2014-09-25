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
import java.awt.Dimension;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
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
        primaryStage.show();

        //MANAGERS//
        AccountManager accountManager = new AccountManager();
        CommmunicationManager communicationManager = new CommmunicationManager();
        ServiceManager serviceManager = new ServiceManager();

        IPropertyReader propertiesReader = new PropertiesReader();

        //Services
        ResourcesReleaser releaser = new ResourcesReleaser(communicationManager);

        //Scene Objects
        frame = new TshaJFrame();
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

        // services subscriptions
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
