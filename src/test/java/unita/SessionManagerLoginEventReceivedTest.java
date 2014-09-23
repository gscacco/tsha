/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import engine.TshaApplication;
import events.SessionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import utility.MockAppSessionManager;

/**
 *
 * @author mpanagrosso
 */
public class SessionManagerLoginEventReceivedTest {

    private static GuiTest controller;

    @BeforeClass
    public static void setUp() {
        FXTestUtils.launchApp(MockAppSessionManager.class);

        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return MockAppSessionManager.getStage().getScene().getRoot();
            }
        };

        controller.doubleClick();
    }

    @Test
    public void shouldCallTheServiceOnSessionEnteredEvent() {

        //setup
        //exercise
        MockAppSessionManager.getFakeCommunicator().post(SessionEvent.SESSION_ENTERED);

       
        //verify
        Assert.assertTrue(MockAppSessionManager.getSpyService().getPreviouslyExecuted());

    }

    @AfterClass
    public static void shutdownAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MockAppSessionManager.getStage().close();
            }
        });

    }

}
