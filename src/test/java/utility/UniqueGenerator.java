/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Dimension;
import java.util.Random;

/**
 *
 * @author mpanagrosso
 */
public class UniqueGenerator {

    private static int _value = 0;

    public static int getInt() {
        return ++_value;
    }

    public static String getString() {
        return "sequence" + (++_value);
    }
    
    
    public static Dimension getRandomDimension(){
    
        Random rand = new Random();
        int width=500, height = 300;
        float multiplier =rand.nextFloat();
        width = width +(int)( width*multiplier);
        height = height + (int) (height*multiplier);
        
       return  new Dimension(width,height);
    }
}
