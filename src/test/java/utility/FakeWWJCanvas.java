/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import javax.swing.JFrame;
import mvc.controller.interfaces.IService;

/**
 *
 * @author mpanagrosso
 */
public class FakeWWJCanvas extends JFrame {
    private WorldWindowGLCanvas wwd;

    public FakeWWJCanvas(WorldWindowGLCanvas wwd) {

        this.wwd = wwd;
        this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
        wwd.setModel(new BasicModel());
    }

    public WorldWindowGLCanvas getWwd() {
        return wwd;
        
    }
    
    
}