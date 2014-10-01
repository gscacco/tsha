/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accettazione;

import static accettazione.LoginPassedTest.controller;
import engine.TshaApplication;
import javafx.application.Platform;
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
public class LoginStartTest {

    static GuiTest controller;

    @BeforeClass
    public static void setUp() {
        controller = SetUpTestUtility.getGuiTestInstance(TshaApplication.class);
        controller.doubleClick();
    }

    @Test
    public void shouldShowLogin() {
        //setup
        controller.doubleClick();
        //verify
        Assert.assertNotNull(controller.find("#loginPanel"));

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
