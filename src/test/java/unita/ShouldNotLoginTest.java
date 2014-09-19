/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import engine.TshaApplication;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import mvc.controller.LoginController;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.controls.Commons;
import org.loadui.testfx.utils.FXTestUtils;
import utility.MockAppLoginController;
import utility.UniqueGenerator;

/**
 *
 * @author mpanagrosso
 */
public class ShouldNotLoginTest {

    private static Node loginPanel;
    private static Node loginButton;
    private static Node userNameField;
    private static Node passwordField;
    private static Node errorLabel;

    static GuiTest controller;

    @BeforeClass
    public static void setUp() {
        FXTestUtils.launchApp(MockAppLoginController.class);

        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return MockAppLoginController.getStage().getScene().getRoot();
            }
        };
        controller.doubleClick();
        setUpNeededControls();
    }

    private static void setUpNeededControls() {
        loginPanel = controller.find("#loginPanel");
        loginButton = loginPanel.lookup("#login");
        userNameField = loginPanel.lookup("#usernameField");
        passwordField = loginPanel.lookup("#passwordField");
        errorLabel = loginPanel.lookup("#errorLabel");
    }

    @Test
    public void shouldNotLogin() {

        //setup
        MockAppLoginController.getAccountManager().setValidationResult(false);

        //exercise
        controller.doubleClick();
        controller.click(userNameField).type(UniqueGenerator.getString());
        controller.click(passwordField).type(UniqueGenerator.getString());
        controller.click(loginButton);
        

        //verify
        Assert.assertTrue(loginPanel.isVisible());

        //lo sleep serve perchè l'assert deve essere eseguito dopo che la transizione è completata
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ShouldNotLoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assert.assertTrue(controller.exists("Invalid credentials"));

    }



    @AfterClass
    public static void shutdownAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MockAppLoginController.getStage().close();
            }
        });

    }
}
