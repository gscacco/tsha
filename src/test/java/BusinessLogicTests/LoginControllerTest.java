/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicTests;

import engine.TshaApplication;
import engine.TshaEventBus;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import mockApplication.EventReceiver;
import mvc.controllers.LoginPanelController;
import org.junit.*;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import reports.SessionEvent;

/**
 *
 * @author mpanagrosso
 */
public class LoginControllerTest {

    Parent root;

    private static GuiTest controller;

    @BeforeClass
    public static void setUpClass() {
        FXTestUtils.launchApp(TshaApplication.class);

        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return TshaApplication.getStage().getScene().getRoot();
            }
        };
        controller.doubleClick();
    }

    @Test
    public void shouldLogUser() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginPanelController.getInstance().getStage().getScene().getRoot();
            }
        };
        Assert.assertTrue(LoginPanelController.getInstance().validate("Utente1", "Password1"));

    }

    @Test
    public void shouldNotLogUser() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginPanelController.getInstance().getStage().getScene().getRoot();
            }
        };
        Assert.assertFalse(LoginPanelController.getInstance().validate("Pippo", "Password2"));

    }

    @Test
    public void shouldPostCommand() {
          EventReceiver receiver = new EventReceiver(TshaEventBus.getInstance());
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginPanelController.getInstance().getStage().getScene().getRoot();
            }
        };

        controller.type("Utente1");
        controller.press(KeyCode.TAB);
        controller.type("Password1");
        controller.click("Login");
        Assert.assertEquals(SessionEvent.SESSION_ENTERED, receiver.sessionEventReport);

    }

    @AfterClass
    public static void shutdownAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                TshaApplication.getStage().close();
            }
        });
    }

}
