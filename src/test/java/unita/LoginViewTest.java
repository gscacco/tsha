/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import utility.MockApp;
import engine.TshaApplication;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
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
public class LoginViewTest {

    private static GuiTest controller;
    
    @BeforeClass
    public static void setUpClass() {
        FXTestUtils.launchApp(MockApp.class);
        
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return MockApp.getStage().getScene().getRoot();
            }
        };
        controller.doubleClick();
    }

//    @Test
//    public void shouldShowNotificationOnError() {
//        Platform.runLater(new Runnable() {
//
//            @Override
//            public void run() {
//                LoginController.getInstance().showView(MockApp.getStage());
//                controller = new GuiTest() {
//                    @Override
//                    protected Parent getRootNode() {
//                        return LoginController.getInstance().getModel();
//                    }
//                };
//                
//            controller.click("#usernameField").type("wrong name");
//            controller.click("#passwordField").type("wrong ");
//                
//            }
//        });
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(LoginViewTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
