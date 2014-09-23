/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import events.SessionEvent;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import managers.SessionManager;
import mvc.controller.TshaMainBarController;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import mvc.controller.interfaces.IService;
import mvc.controller.StartUpGuiController;
import utility.MockAppSessionManager;
import utility.MockAppStartUpGuiService;

/**
 *
 * @author mpanagrosso
 */
public class MainToolBarSizeTest {

    private static GuiTest controller;

    @BeforeClass
    public static void setUp() {
        FXTestUtils.launchApp(MockAppStartUpGuiService.class);

        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return MockAppStartUpGuiService.getStage().getScene().getRoot();
            }
        };

        controller.doubleClick();

    }

    @Test
    public void shouldToolbarBeSizedCorrectly() {

        //setup
        IService service = MockAppStartUpGuiService.getService();
        Dimension screenDimension = MockAppStartUpGuiService.getScreenSize();
        service.execute();
        //exercise

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainToolBarSizeTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        TshaMainBarController mainToolarBar = controller.find("#mainBar");

        //verify
        Assert.assertTrue(mainToolarBar.getHeight() == StartUpGuiController.TOOLBARHEIGHT);
        Assert.assertTrue(mainToolarBar.getWidth() == screenDimension.width);

    }

    @AfterClass
    public static void shutdownAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MockAppStartUpGuiService.getStage().close();
            }
        });
    }
}
