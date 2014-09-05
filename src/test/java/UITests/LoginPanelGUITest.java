package UITests;

import engine.TshaApplication;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import mvc.controllers.LoginPanelController;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;

public class LoginPanelGUITest {

    private static GuiTest controller;

    @BeforeClass
    public static void setUpClass() {
        FXTestUtils.launchApp(TshaApplication.class);

        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return TshaApplication.getStage().getScene().getRoot();
            }
        };
        controller.doubleClick();
    }

    @Before
    public void setUpEachTest() {
        if (!LoginPanelController.getStage().getScene().getWindow().isShowing()) {
            LoginPanelController.getInstance().showView(TshaApplication.getStage());
        }
    }

    @Test
    public void shouldNottHidePanel() {
        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return LoginPanelController.getInstance().getStage().getScene().getRoot();
            }
        };
        controller.click("Login");
        Assert.assertTrue(LoginPanelController.getInstance().getStage().getScene().getWindow().isShowing());

        controller.click("Shut Down");
        controller.doubleClick();
        Assert.assertFalse(LoginPanelController.getStage().getScene().getWindow().isShowing());
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
