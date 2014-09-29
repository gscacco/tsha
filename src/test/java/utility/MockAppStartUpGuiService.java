/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import constants.PropertiesReader;
import events.Events;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.stage.Stage;
import javax.swing.JFrame;
import managers.CommmunicationManager;
import mvc.controller.PopUpConfirmController;
import mvc.controller.TshaMainBarController;
import mvc.controller.interfaces.IService;
import mvc.controller.StartUpGuiController;
import mvc.view.TshaJFrame;

/**
 *
 * @author mpanagrosso
 */
public class MockAppStartUpGuiService extends MockApp {

    private static IService startUpGuiService;
    private static TshaJFrame frame;
    private static TshaMainBarController mainBar;
    private static Dimension screenSize;
    private static Stage mainToolBarStage;

    public static IService getService() {
        return startUpGuiService;
    }

    public static JFrame getFrame() {
        return frame;
    }

    @Override
    public void startSpecifiedComponents() {

        frame = new TshaJFrame(new WorldWindowGLCanvas());
        mainToolBarStage = new Stage();
        CommmunicationManager cm = new CommmunicationManager();
        PropertiesReader pr = new PropertiesReader("src\\main\\resources\\config\\tshaconfig.properties");
        PopUpConfirmController confirmController = new PopUpConfirmController(primaryStage, new Stage(), cm, pr, Events.SESSION_EXITED);
        mainBar = new TshaMainBarController(primaryStage, mainToolBarStage, cm, pr, confirmController);
        screenSize = UniqueGenerator.getRandomDimension();
        startUpGuiService = new StartUpGuiController(primaryStage, frame, mainBar, screenSize);
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static Stage getMainToolBarStage() {
        return mainToolBarStage;
    }

    public static void close() {
        Platform.exit();
    }
}
