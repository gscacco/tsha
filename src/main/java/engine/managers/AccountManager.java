/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.managers;

import domain.User;
import exceptions.DataNotFoundException;
import java.util.HashMap;

/**
 *
 * @author mpanagrosso
 */
public class AccountManager {

    private static AccountManager instance = null;

    // STUB CODE
    private HashMap<String, User> users = new HashMap<>();
    // END STUB CODE

    public static AccountManager getInstance() {

        if (instance == null) {
            instance = new AccountManager();

        }
        return instance;
    }

    // STUB CODE
    public AccountManager() {

        users = populateAccounts();
    }

    private HashMap<String, User> populateAccounts() {
        HashMap<String, User> result = new HashMap<>();
        result.put("Utente1", new User("Utente1", "Password1", "Utente1 Berti"));
        result.put("Utente2", new User("Utente2", "Password2", "Utente2 Nardi"));
        result.put("Utente3", new User("Utent3", "Password3", "Utente3 Gini"));
        result.put("Utente4", new User("Utente4", "Password4", "Utente4 Biancchi"));
        result.put("Utente5", new User("Utent5", "Password4", "Utente5 Rossi"));
        return result;
    }

    public User retrieveUserFromDatabase(String userName, String pwd) throws DataNotFoundException {

        if (users.containsKey(userName) && users.get(userName).getPassWord().equals(pwd)) {
            return users.get(userName);
        } else {
            throw new DataNotFoundException();
        }
    }

        //END STUB CODE
}
