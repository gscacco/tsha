/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import engine.TshaApplication;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import utility.MockAppLoginController;
import utility.UniqueGenerator;

/**
 *
 * @author mpanagrosso
 */
public class ShouldLoginTest {

   private static Node loginPanel;
    private static Node loginButton;
    private static Node userNameField;
    private static Node passwordField;
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

    private static void  setUpNeededControls() {
        loginPanel = controller.find("#loginPanel");
        loginButton = loginPanel.lookup("#login");
        userNameField = loginPanel.lookup("#usernameField");
        passwordField = loginPanel.lookup("#passwordField");
    }

    @Test
    public void shouldLogin() {

        //setup
        MockAppLoginController.getAccountManager().setValidationResult(true);
       
        //exercise
        controller.doubleClick();
        controller.click(userNameField).type(UniqueGenerator.getString());
        controller.click(passwordField).type(UniqueGenerator.getString());
        controller.click(loginButton);
        //verify

        Assert.assertFalse(loginPanel.isVisible());

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
