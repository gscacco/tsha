/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import engine.TshaApplication;
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
        FXTestUtils.launchApp(appClass);

        return new GuiTest() {
            @Override
            protected Parent getRootNode() {
                return TshaApplication.getStage().getScene().getRoot();
            }
        };

    }

}
