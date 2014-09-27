/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accettazione;

import static accettazione.LoginPassedTest.controller;
import engine.TshaApplication;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.SetUpTestUtility;

/**
 *
 * @author mpanagrosso
 */
public class LogOutTest {

    private static Node loginPanel;
    private static Node loginButton;
    private static Node userNameField;
    private static Node passwordField;
    private static Node mainToolBar;
    private static Node logoutButton;

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
    public void shouldLogOutAfterLogin() {
        controller.doubleClick();
        controller.click(userNameField).type("Utente1");
        controller.click(passwordField).type("Password1");
        controller.click(loginButton);

        mainToolBar = controller.find("#mainBar");
        logoutButton = mainToolBar.lookup("#logoutButton");
        controller.click(logoutButton);
      
        Assert.assertFalse(mainToolBar.isVisible());
        Assert.assertFalse(TshaApplication.getFrame().isVisible());
        Assert.assertTrue(loginPanel.isVisible());

    }
    
    
}
