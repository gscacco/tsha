/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import javafx.application.Platform;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import utility.MockAppResourcesReleaser;
import utility.SetUpTestUtility;
import utility.SpyiService;

/**
 *
 * @author mpanagrosso
 */
public class ResourcesReleaserTest {
    


    private static GuiTest controller;

    @BeforeClass
    public static void setUp() {

        controller = SetUpTestUtility.getGuiTestInstance(MockAppResourcesReleaser.class);
        controller.doubleClick();

    }

    @Test
    public void shouldReleaseResources() {
    SpyiService service = new SpyiService();
     SpyiService service2 = new SpyiService();
    MockAppResourcesReleaser.getReleaser().register(service);
      MockAppResourcesReleaser.getReleaser().register(service2);
    MockAppResourcesReleaser.getReleaser().release();
    Assert.assertTrue(service.verifyIsReleased());
    Assert.assertTrue(service2.verifyIsReleased());

    }

    @AfterClass
    public static void shutdownAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MockAppResourcesReleaser.getStage().close();
            }
        });
    }
}

    
    

