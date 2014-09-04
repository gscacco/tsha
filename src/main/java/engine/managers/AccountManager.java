/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.managers;

import domain.User;
import exceptions.DataNotFoundException;

/**
 *
 * @author mpanagrosso
 */
public class AccountManager {

    private static AccountManager instance = null;

    public static AccountManager getInstance() {

        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public User retrieveUserFromDatabase(String userName, String pwd) throws DataNotFoundException {
        //STUB CODE

        if (userName.equals("UtenteTest") && pwd.equals("Pa$$wordTest")) {

            User user = new User("pippo", "pluto", "paperino");
            user.setUserName(userName);
            user.setPassWord(pwd);
            user.setFullName("Marco Bianchi");
            return user;
        } else {
            throw new DataNotFoundException();
        }

    }

}
