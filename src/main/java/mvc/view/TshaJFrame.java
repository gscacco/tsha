/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import javax.swing.JFrame;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class TshaJFrame extends JFrame implements IService {

    public TshaJFrame(){
    setAlwaysOnTop(true);
    setUndecorated(true);
    }
    @Override
    public void execute() {
        setVisible(true);
    }

    @Override
    public void release() {
        setVisible(false);
    }

}
