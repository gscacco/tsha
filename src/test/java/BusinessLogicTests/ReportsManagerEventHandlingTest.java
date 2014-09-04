
package BusinessLogicTests;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import engine.TshaApplication;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import mvc.controllers.LoginPanelController;
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

    public class ReportsManagerEventHandlingTest {

    private static GuiTest controller;


 
    @BeforeClass
    public static void setUpClass() {
            FXTestUtils.launchApp(TshaApplication.class);


           
            controller = new GuiTest() {
                @Override
                protected Parent getRootNode() {
                       System.out.println("from gui test " );
                    return TshaApplication.getStage().getScene().getRoot();
                }
            };
   


        }


 
    @Test
    public void verifyThatCredentialsAreNotOk() {
        
        try {
            
            GuiTest controller2 = new GuiTest() {
                @Override
                protected Parent getRootNode() {
                    return LoginPanelController.getInstance().getStage().getScene().getRoot();
                }
            };
            

            String str = "Pippo";
            String str2 = "Password2";
            controller2.type(str);
            controller2.press(KeyCode.TAB);
            controller2.type(str2);
            controller2.click("Login");
            Assert.assertNotNull(controller2.find(LoginPanelController.INVALID_CREDENTIALS));
            Thread.sleep(2000);
            
            String str3 = "Password1";
            Scene scene =  LoginPanelController.getInstance().getStage().getScene();
            Node node = scene.lookup("#userName");
            controller2.doubleClick(node);
            controller.eraseCharacters(str.length());
            controller2.type(str);
            node = scene.lookup("#passWord");
            controller2.click(node);
            controller.eraseCharacters(str2.length());

            controller2.type(str3);
            controller2.click("Login");
            try {
                controller2.find(LoginPanelController.INVALID_CREDENTIALS);
                Assert.assertTrue(false);
            } catch (Exception ex) {
                Assert.assertTrue(true);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(ReportsManagerEventHandlingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
 
       

      

    }
    
      

    
    @AfterClass
    public static void shutdownAll(){
        Platform.runLater(new Runnable() {
            @Override public void run() {
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



    /**
     * This makes sure that all of the processes shut down when they are supposed to, especially since these test
     * open and close the GUI so many times, without this, the program goes crazy. 
     */
 


