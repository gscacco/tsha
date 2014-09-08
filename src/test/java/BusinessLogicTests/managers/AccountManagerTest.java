/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogicTests.managers;

import engine.managers.AccountManager;
import exceptions.DataNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mpanagrosso
 */
public class AccountManagerTest {

    
    @Test
    public void shouldRetrieveUser() {
        try {
            Assert.assertNotNull(AccountManager.getInstance().retrieveUserFromDatabase("Utente1", "Password1"));
        } catch (DataNotFoundException ex) {
            Logger.getLogger(AccountManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
        
 @Test (expected=DataNotFoundException.class)
    public void shouldNotRetrieveUser() throws DataNotFoundException {
        
           AccountManager.getInstance().retrieveUserFromDatabase("UtenteErrato", "PasswordErrata");
     
       
    }
}
