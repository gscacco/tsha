/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import managers.interfaces.IAccountManager;

/**
 *
 * @author mpanagrosso
 */
public class FakeAccountManager implements IAccountManager {

    boolean validationResult = false;

    public void setValidationResult(boolean result) {
        validationResult = result;
    }

    @Override
    public boolean checkUserValidity(String userName, String passWord) {
        return validationResult;
    }
}
