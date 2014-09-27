/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import javax.swing.JFrame;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class TshaJFrame extends JFrame implements IService {
    private WorldWindowGLCanvas wwd;

    public TshaJFrame(WorldWindowGLCanvas wwd) {
        setAlwaysOnTop(true);
        setUndecorated(true);
        this.wwd = wwd;
        this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
        wwd.setModel(new BasicModel());
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
