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
public class SpyiService implements IService {

    boolean isReleased = false;
    boolean previouslyExecuted = false;

    @Override
    public void execute() {
        previouslyExecuted = true;

    }

    public boolean verifyIsExecuted() {
        return previouslyExecuted;
    }

    public boolean verifyIsReleased() {
        return isReleased;
    }

    @Override
    public void release() {
        isReleased = true;
    }

}
