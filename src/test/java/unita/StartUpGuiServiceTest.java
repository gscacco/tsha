package unita;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import mvc.controller.TshaMainBarController;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import mvc.controller.interfaces.IService;
import utility.MockAppStartUpGuiService;

/**
 *
 * @author mpanagrosso
 */
public class StartUpGuiServiceTest {

    private static GuiTest controller;

    @BeforeClass
    public static void setUp() {
        FXTestUtils.launchApp(MockAppStartUpGuiService.class);

        controller = new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return MockAppStartUpGuiService.getStage().getScene().getRoot();
            }
        };

        controller.doubleClick();

    }

   @Test
    public void shouldServiceSetMainBarAndJFrame() {
        //setup
        IService service = MockAppStartUpGuiService.getService();
        //exercise
        service.execute();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(StartUpGuiServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        TshaMainBarController mainToolBar = controller.find("#mainBar");

        //verify
        Assert.assertTrue(MockAppStartUpGuiService.getFrame().isVisible());
        Assert.assertNotNull(mainToolBar);
    }

    @AfterClass
    public static void shutdownAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MockAppStartUpGuiService.getStage().close();
            }
        });
    }
}
