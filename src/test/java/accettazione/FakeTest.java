/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accettazione;

import static accettazione.ShouldNotLoginTest.controller;
import engine.TshaApplication;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import mvc.controller.LoginController;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;

/**
 *
 * @author mpanagrosso
 */
public class FakeTest {

    static GuiTest controller;

    @BeforeClass
    public static void setUp() {
        FXTestUtils.launchApp(TshaApplication.class);

        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return TshaApplication.getStage().getScene().getRoot();
            }
        };

    }

    @Test
    public void shouldLogin() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginController.getInstance().getModel();
            }
        };

        controller.type("Utente1");
        controller.type(KeyCode.TAB);
        controller.type("Password1");
        controller.click("#login");
        Assert.assertFalse(LoginController.getStage().getScene().getWindow().isShowing());

    }
    
    
    
    @Test
    public void shouldNotLogin() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginController.getInstance().getModel();
            }
        };

        controller.type("Pippo");
        controller.type(KeyCode.TAB);
        controller.type("Password1");
        controller.click("#login");
        Assert.assertTrue(LoginController.getStage().getScene().getWindow().isShowing());

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
