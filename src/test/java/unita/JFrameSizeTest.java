/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import mvc.controller.interfaces.IService;
import mvc.controller.StartUpGuiController;
import utility.MockAppStartUpGuiService;
import utility.SetUpTestUtility;

/**
 *
 * @author mpanagrosso
 */
public class JFrameSizeTest {

    private static GuiTest controller;

    @BeforeClass
    public static void setUp() {
        controller = SetUpTestUtility.getGuiTestInstance(MockAppStartUpGuiService.class);
        controller.doubleClick();

    }

    @Test
    public void shouldJFrameBeSizedCorrectly() {

        //setup
        Dimension screenDimension = MockAppStartUpGuiService.getScreenSize();
        IService service = MockAppStartUpGuiService.getService();
        service.execute();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(JFrameSizeTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verify
        Assert.assertTrue(MockAppStartUpGuiService.getFrame().getWidth() == screenDimension.width);
        Assert.assertTrue(MockAppStartUpGuiService.getFrame().getHeight() == (screenDimension.height - StartUpGuiController.TOOLBARHEIGHT));

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
