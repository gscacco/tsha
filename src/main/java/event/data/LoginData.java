/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package event.data;

/**
 *
 * @author mpanagrosso
 */
public class LoginData implements ExchangeData{
    String userName;
    String passWord;

    public LoginData() {
    }
    
    public LoginData(String user, String passWord) {
        this.userName = user;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassWord() {
        return passWord;
    }

    
    
    
    
    
}
