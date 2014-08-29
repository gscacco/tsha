/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.loadui.testfx.Assertions.verifyThat;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.categories.TestFX;
import static org.loadui.testfx.controls.Commons.hasText;

/**
 *
 * @author Mirko
 */
@Category(TestFX.class)
public class FirstTest extends GuiTest {

    @Override
    protected Parent getRootNode() {
        System.out.println("INSIDE");
        final Button btn = new Button();
        btn.setId("btn");
        btn.setText("Hello World");
        btn.setOnAction((actionEvent) -> btn.setText("was clicked"));
        return btn;
    }

    @Test
    public void shouldClickButton() {
        final Button button = find("#btn");
        System.out.println("INSIDE");
        click(button);
        verifyThat("#btn", hasText("was clicked"));
    }
}
