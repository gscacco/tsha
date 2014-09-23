/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import mvc.controller.StartUpGuiController;
import managers.CommmunicationManager;
import constants.IPropertyReader;
import constants.PropertiesReader;
import java.awt.Dimension;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.swing.JFrame;
import managers.AccountManager;
import managers.SessionManager;
import mvc.controller.LoginController;
import mvc.controller.TshaMainBarController;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class TshaApplication extends Application {

    private static Stage primaryStage;
    private static JFrame frame;

    public static JFrame getFrame() {
        return frame;
    }
    private SessionManager sessionManager;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        primaryStage.show();
        AccountManager accountManager = new AccountManager();
        CommmunicationManager communicationManager = new CommmunicationManager();
        IPropertyReader propertiesReader = new PropertiesReader();
        frame = new JFrame();
        TshaMainBarController mainBar = new TshaMainBarController(new Stage(), propertiesReader);
        IService startUpGuiController = new StartUpGuiController(primaryStage, frame, mainBar,
                new Dimension(Integer.parseInt(propertiesReader.readProperty("width")),
                        Integer.parseInt(propertiesReader.readProperty("height"))));

        IService loginController = new LoginController(accountManager, communicationManager, new Stage(), propertiesReader);
        sessionManager = new SessionManager(primaryStage, communicationManager, startUpGuiController, loginController);

    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);

    }

}
