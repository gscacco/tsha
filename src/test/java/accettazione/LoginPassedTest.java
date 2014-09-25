/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accettazione;

import engine.TshaApplication;
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
import utility.SetUpTestUtility;

/**
 *
 * @author mpanagrosso
 */
public class LoginPassedTest {

    private static Node loginPanel;
    private static Node loginButton;
    private static Node userNameField;
    private static Node passwordField;
    static GuiTest controller;

    @BeforeClass
    public static void setUp() {

        controller = SetUpTestUtility.getGuiTestInstance(TshaApplication.class);
        controller.doubleClick();
        setUpNeededControls();
    }

    private static void setUpNeededControls() {
        loginPanel = controller.find("#loginPanel");
        loginButton = loginPanel.lookup("#login");
        userNameField = loginPanel.lookup("#usernameField");
        passwordField = loginPanel.lookup("#passwordField");
    }


    @Test
    public void shouldLogin() {

        //setup
        //exercise
        controller.doubleClick();
        controller.click(userNameField).type("Utente1");
        controller.click(passwordField).type("Password1");
        controller.click(loginButton);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginPassedTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //verify
        Assert.assertTrue(TshaApplication.getFrame().isVisible());
        Assert.assertNotNull(controller.find("#mainBar"));
        Assert.assertTrue(TshaApplication.getStage().getOpacity() == 0);

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
