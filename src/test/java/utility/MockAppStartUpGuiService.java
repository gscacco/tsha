/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import constants.PropertiesReader;
import java.awt.Dimension;
import javafx.stage.Stage;
import javax.swing.JFrame;
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

        frame = new TshaJFrame();
        mainToolBarStage = new Stage();
        mainBar = new TshaMainBarController(primaryStage,mainToolBarStage,new FakeCommunicationManager(), new PropertiesReader());
        screenSize = UniqueGenerator.getRandomDimension();
        startUpGuiService = new StartUpGuiController(primaryStage, frame, mainBar, screenSize);
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static Stage getMainToolBarStage() {
        return mainToolBarStage;
    }

}
