/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accettazione;

import engine.TshaApplication;
import javafx.application.Platform;
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
public class ApplicationStartTest {

    static GuiTest controller;

    @BeforeClass
    public static void setUp() {
       controller = SetUpTestUtility.getGuiTestInstance(TshaApplication.class);
        controller.doubleClick();

    }

    @Test
    public void shouldRun() {
        //setup
        controller.doubleClick();
 
        Assert.assertTrue(TshaApplication.getStage().isShowing());

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
