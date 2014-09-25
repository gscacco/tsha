/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Platform;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;
import mvc.controller.interfaces.IService;
import mvc.view.TshaJFrame;

/**
 *
 * @author mpanagrosso
 */
public class StartUpGuiController implements IService {

    public static final int TOOLBARHEIGHT = 50;
    private TshaJFrame frame;
    private TshaMainBarController mainBar;
    private Dimension screenSize;
    private Stage primaryStage;

    public StartUpGuiController(Stage primaryStage, TshaJFrame frame, TshaMainBarController mainBar, Dimension screenSize) {
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
                frame.execute();

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

    @Override
    public void release() {
        mainBar.release();
        frame.release();
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

}
