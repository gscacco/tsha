/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers.interfaces;

/**
 *
 * @author mpanagrosso
 */
public interface IAccountManager {

    public boolean checkUserValidity(String userName, String passWord);

}
