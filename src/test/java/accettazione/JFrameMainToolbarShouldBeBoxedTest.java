/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accettazione;

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
import utility.MockAppStartUpGuiService;
import utility.SetUpTestUtility;

/**
 *
 * @author mpanagrosso
 */
public class JFrameMainToolbarShouldBeBoxedTest {

    private static GuiTest controller;

    @BeforeClass
    public static void setUp() {

        controller = SetUpTestUtility.getGuiTestInstance(MockAppStartUpGuiService.class);
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
