/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unita;

import managers.AccountManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mpanagrosso
 */
public class AccountManagerTest {

    private static AccountManager manager;

    @BeforeClass
    public static void setUp() {
        manager = new AccountManager();
    }

    @Test
    public void shouldValidateRegisteredUsers() {
        Assert.assertTrue(manager.checkUserValidity("Utente1", "Password1"));
        Assert.assertTrue(manager.checkUserValidity("Utente2", "Password2"));
        Assert.assertTrue(manager.checkUserValidity("Utente3", "Password3"));

    }
}
