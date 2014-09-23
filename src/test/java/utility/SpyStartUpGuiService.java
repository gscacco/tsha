/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Dimension;
import javafx.stage.Stage;
import javax.swing.JFrame;
import mvc.controller.TshaMainBarController;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class SpyStartUpGuiService implements IService {

    boolean value = false;
    boolean previouslyExecuted = false;

    public SpyStartUpGuiService() {

    }

    public void setExecuteReturnValue(boolean value) {
        this.value = value;
    }

    @Override
    public void execute() {
        previouslyExecuted = true;
       
    }

    public boolean getPreviouslyExecuted() {
        return previouslyExecuted;
    }

    @Override
    public void execute(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
