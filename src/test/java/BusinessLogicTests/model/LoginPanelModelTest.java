/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicTests.model;

import mvc.model.LoginPanelModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mpanagrosso
 */
public class LoginPanelModelTest {

    
       static LoginPanelModel model;

    @BeforeClass
    public static void setUp() {
        model = new LoginPanelModel();

    }
    
    @Test
    public void rightUserNameInput() {
        
        Assert.assertFalse(model.checkUserNameValidity("_testprimo"));
        Assert.assertFalse(model.checkUserNameValidity("_test"));
        Assert.assertFalse(model.checkUserNameValidity("5testprimo"));
        Assert.assertTrue(model.checkUserNameValidity("testprimo_5"));
        Assert.assertTrue(model.checkUserNameValidity("te_st_5_primo"));
    }

    @Test
    public void rightPasswordInput() {
   

        Assert.assertTrue(model.checkPassWordValidity("this_is_pa$$"));
        Assert.assertTrue(model.checkPassWordValidity("Pa$$Word_&5"));
        Assert.assertFalse(model.checkPassWordValidity("Pa$$"));
        Assert.assertTrue(model.checkPassWordValidity("$0f1st1c4t3dpa$$"));
    }
}
