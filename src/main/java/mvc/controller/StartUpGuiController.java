/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import gov.nasa.worldwind.render.airspaces.ScreenSizeDetailLevel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Platform;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import mvc.controller.TshaMainBarController;
import mvc.controller.TshaMainBarController;
import mvc.controller.interfaces.IService;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class StartUpGuiController implements IService {

    public static final int TOOLBARHEIGHT = 50;
    private JFrame frame;
    private TshaMainBarController mainBar;
    private Dimension screenSize;
    private Stage primaryStage;

    public StartUpGuiController(Stage primaryStage, JFrame frame, TshaMainBarController mainBar, Dimension screenSize) {
        this.primaryStage = primaryStage;
        this.frame = frame;
        this.mainBar = mainBar;
        this.screenSize = screenSize;
    }

    @Override
    public void execute() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setFrame();

            }
        });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setMainToolBar();
                primaryStage.setOpacity(0);

            }
        });

    }

    private void setFrame() {
        frame.setAlwaysOnTop(true);
        frame.setUndecorated(true);
        frame.setSize(new Dimension(screenSize.width, screenSize.height - TOOLBARHEIGHT));
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int xPos = width / 2 - screenSize.width / 2;
        int yPos = height / 2 - screenSize.height / 2;
        frame.setLocation(xPos, yPos);
        frame.setVisible(true);
    }

    private void setMainToolBar() {

        mainBar.setSize((double) screenSize.width, (double) TOOLBARHEIGHT);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int xPos = width / 2 - screenSize.width / 2;
        int yPos = (height / 2 - screenSize.height / 2) + screenSize.height - TOOLBARHEIGHT;
        mainBar.setLocation(xPos, yPos);
        mainBar.showView(primaryStage);

    }

    @Override
    public void execute(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
