/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import utility.MockAppLoginController;
import utility.SetUpTestUtility;
import utility.UniqueGenerator;

/**
 *
 * @author mpanagrosso
 */
public class ShouldErrorPanelDisapperAfterKeyPressed {

    private static Node loginPanel;
    private static Node loginButton;
    private static Node userNameField;
    private static Node passwordField;
    private static Node errorLabel;
    private static Node errorPanel;

    static GuiTest controller;

    @BeforeClass
    public static void setUp() {
        controller = SetUpTestUtility.getGuiTestInstance(MockAppLoginController.class);
        controller.doubleClick();
        setUpNeededControls();
    }

    private static void setUpNeededControls() {
        loginPanel = controller.find("#loginPanel");
        loginButton = loginPanel.lookup("#login");
        userNameField = loginPanel.lookup("#usernameField");
        passwordField = loginPanel.lookup("#passwordField");
        errorLabel = loginPanel.lookup("#errorLabel");
        errorPanel = loginPanel.lookup("#errorPanel");
    }

    @Test
    public void shouldErrorPanelDisappearAfterKeyPressed() {
        //setup
        MockAppLoginController.getAccountManager().setValidationResult(false);

        //exercise
        controller.doubleClick();
        controller.click(userNameField).type(UniqueGenerator.getString());

        controller.click(passwordField).type(UniqueGenerator.getString());
        controller.click(loginButton);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ShouldNotLoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        controller.click(userNameField).type("23");

        //lo sleep serve perchè l'assert deve essere eseguito dopo che la transizione è completata
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ShouldNotLoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verify
        Assert.assertEquals(errorPanel.getTranslateY(), -60.0, 0);
    }

    @AfterClass
    public static void shutdownAll() {
        Platform.runLater(() -> {
            MockAppLoginController.getStage().close();
        });

    }
}
