/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogicTests;

import javafx.scene.Parent;
import mvc.controllers.LoginPanelViewController;
import org.junit.*;
/**
 *
 * @author mpanagrosso
 */
public class LoginControllerTest {
    LoginPanelViewController controller;
    Parent root;
    @Before
    public void setup(){
    
     controller = new LoginPanelViewController();
    
    
    }
    
    @After
    public void tearDown(){
        controller = null;
    
    }
    
    
    @Test
    public void ShouldLogUser(){
        
    Assert.assertTrue(controller.validate("UtenteTest","Pa$$wordTest"));
        
    }
    
    @Test
    public void ShouldNotLogUser(){
        
    Assert.assertFalse(controller.validate("UserTest1","Pa$$wordTest"));
        
    }
    
}
