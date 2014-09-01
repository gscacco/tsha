/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UITests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import junit.framework.Assert;
import mvc.controllers.LoginPanelViewController;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.loadui.testfx.GuiTest;
import static org.loadui.testfx.GuiTest.find;
import org.loadui.testfx.categories.TestFX;

/**
 *
 * @author Mirko
 */
@Category(TestFX.class)
public class LoginPanelTest extends GuiTest {



    @Override
    protected Parent getRootNode() {
         URL url = null;
        FXMLLoader loader = null;
        try {
            java.nio.file.Path path = Paths.get("");
            System.out.println("file1:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\components\\LoginPanelView.fxml");

            url = new URL("file1:/" + path.toAbsolutePath().toString() + "\\src\\main\\java\\mvc\\view\\components\\LoginPanelView.fxml");

            loader = new FXMLLoader(url);
            loader.setRoot(new AnchorPane());
            loader.load();

        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginPanelTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginPanelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       return  loader.getRoot();

    }

    @Test
    public void shouldLoginCorrectHidePanel() {
        Parent loginPanel = find("#AnchorPane");
        Button login = find("#login");
        click(login);
        Assert.assertFalse( loginPanel.getScene().getWindow().isShowing());
    }
    
    @Test
    public void shouldShutDownHidePanel() {
        Parent loginPanel = find("#AnchorPane");
        Button shutDown = find("#shutDown");
        click(shutDown);
       
        Assert.assertFalse( loginPanel.getScene().getWindow().isShowing());
    }
    
    @Test
    public void rightUserNameInput() {

        LoginPanelViewController logControl = new LoginPanelViewController();
        Assert.assertFalse(logControl.checkUserNameValidity("_testprimo"));
        Assert.assertFalse(logControl.checkUserNameValidity("_test"));
        Assert.assertFalse(logControl.checkUserNameValidity("5testprimo"));
        Assert.assertTrue(logControl.checkUserNameValidity("testprimo_5"));
        Assert.assertTrue(logControl.checkUserNameValidity("te_st_5_primo"));
    }
    
    
        @Test
    public void rightPasswordInput() {

        LoginPanelViewController logControl = new LoginPanelViewController();
    
        Assert.assertTrue(logControl.checkPassWordValidity("this_is_pa$$"));
        Assert.assertTrue(logControl.checkPassWordValidity("Pa$$Word_&5"));
        Assert.assertFalse(logControl.checkPassWordValidity("Pa$$"));
        Assert.assertTrue(logControl.checkPassWordValidity("$0f1st1c4t3dpa$$"));
    }
}
