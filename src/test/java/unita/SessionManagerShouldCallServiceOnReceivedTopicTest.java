/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import events.Events;
import javafx.application.Platform;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import utility.MockAppSessionManager;
import utility.SetUpTestUtility;
import utility.SpyiService;

/**
 *
 * @author mpanagrosso
 */
public class SessionManagerShouldCallServiceOnReceivedTopicTest {

    private static GuiTest controller;

    @BeforeClass
    public static void setUp() {

        controller = SetUpTestUtility.getGuiTestInstance(MockAppSessionManager.class);
        controller.doubleClick();
    }
    enum fakeEvents{
    FAKETOPIC
    }

    @Test
    public void shouldCallTheServiceOnSessionEnteredEvent() {

        //setup
        
        //exercise
        SpyiService spyService = new SpyiService();
        MockAppSessionManager.getFakeServiceManager().register(Events.SESSION_ENTERED, spyService);  
        MockAppSessionManager.getFakeCommunicator().post(Events.SESSION_ENTERED);

        //verify
        System.out.println("spyService.verifyIsExecuted() " + spyService.verifyIsExecuted() );
        Assert.assertTrue(spyService.verifyIsExecuted());

    }

    @AfterClass
    public static void shutdownAll() {
        Platform.runLater(() -> {
            MockAppSessionManager.getStage().close();
        });

    }

}
