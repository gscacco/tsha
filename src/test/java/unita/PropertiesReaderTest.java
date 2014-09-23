/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import constants.PropertiesReader;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mpanagrosso
 */
public class PropertiesReaderTest {
    static PropertiesReader reader;
    
    @BeforeClass
    public static void setUp(){
     reader = new PropertiesReader();
    }
    
    
    @Test
    public void shouldReadValuesStoredInConfigFile(){
   Assert.assertEquals(reader.getProperty("width"), "1366");
   Assert.assertEquals(reader.getProperty("views"), "\\src\\main\\java\\mvc\\view\\");
        
    }
}
