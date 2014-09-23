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
import utility.MockAppSessionManager;
import utility.MockAppStartUpGuiService;

/**
 *
 * @author mpanagrosso
 */
public class JFrameMainToolbarShouldBeBoxedTest {

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
    public void shouldPanelsBeBoxed() {
        //setup
        IService service = MockAppStartUpGuiService.getService();
        service.execute();
        //exercise
  
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JFrameMainToolbarShouldBeBoxedTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Dimension frameDimension = MockAppStartUpGuiService.getFrame().getSize();

        //verify
        Assert.assertTrue(MockAppStartUpGuiService.getMainToolBarStage().getX() == MockAppStartUpGuiService.getFrame().getX());
        Assert.assertTrue(MockAppStartUpGuiService.getMainToolBarStage().getY() == MockAppStartUpGuiService.getFrame().getY() + frameDimension.getHeight());

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
