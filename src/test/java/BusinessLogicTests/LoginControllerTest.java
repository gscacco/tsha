/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicTests;

import engine.TshaApplication;
import event.data.LoginData;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
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

    }

    @Test
    public void ShouldLogUser() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginPanelController.getInstance().getStage().getScene().getRoot();
            }
        };
        controller.rightClick();
        Assert.assertTrue(LoginPanelController.getInstance().validate("Pippo", "Password1"));

    }

    @Test
    public void ShouldNotLogUser() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginPanelController.getInstance().getStage().getScene().getRoot();
            }
        };
        controller.rightClick();
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
//        try {
//            Runtime.getRuntime().exec("taskkill /F /IM external_program.exe");
//        } catch (IOException ex) {
//           Logger.getLogger(LoginPanelViewController.class.getName()).log(Level.SEVERE, null, ex);
//
//        }        
    }

}
