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
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import utility.SetUpTestUtility;

/**
 *
 * @author mpanagrosso
 */
public class ShutDownTest {
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    private static Node loginPanel;
    private static Node shutDownButton;

    static GuiTest controller;

    @BeforeClass
    public static void setUp() {

        controller = SetUpTestUtility.getGuiTestInstance(TshaApplication.class);
        controller.doubleClick();
        setUpNeededControls();
    }

    private static void setUpNeededControls() {
        loginPanel = controller.find("#loginPanel");
        shutDownButton = loginPanel.lookup("#shutDownButton");

    }

    @Test
    public void shouldShutDownApplication() {

        //setup
        //exercise
        controller.doubleClick();

        controller.click(shutDownButton);
  
        //verify

        Assert.assertFalse(TshaApplication.getStage().isShowing());

    }

  
         @AfterClass
    public static void shutdownAll(){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                TshaApplication.getStage().close();
            }
         });
     
    }
}
