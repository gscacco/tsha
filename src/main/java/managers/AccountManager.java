/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import managers.interfaces.IAccountManager;

/**
 *
 * @author mpanagrosso
 */
public class AccountManager implements IAccountManager {

    @Override
    public boolean checkUserValidity(String userName, String password) {
        if (userName.equals("Utente1")
                && password.equals("Password1")) {
            return true;
        }
        if (userName.equals("Utente2")
                && password.equals("Password2")) {
            return true;
        }
        if (userName.equals("1")
                && password.equals("1")) {
            return true;
        }
        return false;
    }

}
