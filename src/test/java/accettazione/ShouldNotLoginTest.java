/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accettazione;

import engine.TshaApplication;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
public class ShouldNotLoginTest {

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
    public void shouldNotLogin() {
        //setup
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginController.getInstance().getModel();
            }
        };

        //exercise
        controller.type("Pippo");
        controller.type(KeyCode.TAB);
        controller.type("Password1");
        controller.click("#login");
        //verify
        Assert.assertTrue(LoginController.getStage().getScene().getWindow().isShowing());
        Assert.assertTrue(controller.exists("Invalid Credentials"));

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
