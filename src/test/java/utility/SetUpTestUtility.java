/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import engine.TshaApplication;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Parent;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;

/**
 *
 * @author mpanagrosso
 */
public class SetUpTestUtility {

    public static GuiTest getGuiTestInstance(Class<? extends Application> appClass) {
        
        String[] args= {"-c", "src\\main\\resources\\config\\appconfig\\tshaconfig.properties"};
        FXTestUtils.launchApp(appClass,args);

        return new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return TshaApplication.getStage().getScene().getRoot();
            }
        };

    }

}
