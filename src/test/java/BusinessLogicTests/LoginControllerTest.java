/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicTests;

import engine.TshaApplication;
import javafx.application.Platform;
import javafx.scene.Parent;
import mvc.controllers.LoginPanelController;
import org.junit.*;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;

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
    public void ShouldLogUser() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginPanelController.getInstance().getStage().getScene().getRoot();
            }
        };
        Assert.assertTrue(LoginPanelController.getInstance().validate("Utente1", "Password1"));

    }

    @Test
    public void ShouldNotLogUser() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginPanelController.getInstance().getStage().getScene().getRoot();
            }
        };
        Assert.assertFalse(LoginPanelController.getInstance().validate("Pippo", "Password2"));

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
