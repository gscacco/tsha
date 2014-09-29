/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import mvc.controller.ResourcesReleaser;
import mvc.controller.StartUpGuiController;
import managers.CommmunicationManager;
import constants.PropertiesReader;
import events.Events;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

import java.awt.Dimension;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JFrame;
import managers.AccountManager;
import managers.ServiceManager;
import managers.SessionManager;
import mvc.controller.LoginController;
import mvc.controller.PopUpConfirmController;
import mvc.controller.TshaMainBarController;
import mvc.view.TshaJFrame;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author mpanagrosso
 */
public class TshaApplication extends Application {

    private static Stage primaryStage;
    private static TshaJFrame frame;
    private PropertiesReader propertiesReader;
    private SessionManager sessionManager;
    private static CommandLine commandLine;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        //MANAGERS//
        AccountManager accountManager = new AccountManager();
        CommmunicationManager communicationManager = new CommmunicationManager();
        ServiceManager serviceManager = new ServiceManager();
        propertiesReader = new PropertiesReader(commandLine.getOptionValue("c"));

        //setUp stage and Jframe creation
        setUp();

        //Services
        ResourcesReleaser releaser = new ResourcesReleaser(communicationManager);

        //Scene Objects
        PopUpConfirmController confirmController = new PopUpConfirmController(
                primaryStage,
                new Stage(),
                communicationManager,
                propertiesReader,
                Events.SESSION_EXITED);

        TshaMainBarController mainBar = new TshaMainBarController(
                primaryStage,
                new Stage(),
                communicationManager,
                propertiesReader,
                confirmController);

        int screenWidth = Integer.parseInt(propertiesReader.readProperty("width"));
        int screenHeight = Integer.parseInt(propertiesReader.readProperty("height"));
        Dimension screenDimension = new Dimension(screenWidth, screenHeight);

        StartUpGuiController startUpGuiController = new StartUpGuiController(
                primaryStage,
                frame,
                mainBar,
                screenDimension);

        serviceManager.register(Events.SESSION_ENTERED, startUpGuiController);
        releaser.register(startUpGuiController);

        LoginController loginController = new LoginController(accountManager,
                communicationManager,
                primaryStage,
                new Stage(),
                propertiesReader);

        serviceManager.register(Events.SESSION_WAITING_LOGIN, loginController);

        serviceManager.register(Events.SESSION_EXITED, releaser);

        sessionManager = new SessionManager(primaryStage, communicationManager, serviceManager);

    }

    private void setUp() {
        Group primaryGroup = new Group();
        int screenOffset = 5;
        Scene primaryScene = new Scene(primaryGroup, Integer.parseInt(propertiesReader.readProperty("width")) - screenOffset,
                Integer.parseInt(propertiesReader.readProperty("height")), Color.DARKGRAY);

        primaryStage.setY(0);
        primaryStage.setX(0);
        primaryStage.setScene(primaryScene);
        primaryStage.initStyle(StageStyle.UTILITY);

        primaryStage.show();
        frame = new TshaJFrame(new WorldWindowGLCanvas());
    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static JFrame getFrame() {
        return frame;
    }

    private static void parseCommandLineArguments(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("c", "config", true, "Configuration properties file");
        options.addOption("h", "help", false, "Print help");
        CommandLineParser parser = new BasicParser();
        commandLine = parser.parse(options, args);

        boolean printHelp = (commandLine.hasOption("h")) || (!commandLine.hasOption("c"));
        if (printHelp) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("TSHA", options);
            System.exit(0);
        }
    }

    public static void main(String[] args) throws ParseException {
        parseCommandLineArguments(args);
        launch(args);

    }

}
