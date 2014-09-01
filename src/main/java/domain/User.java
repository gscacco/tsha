package domain;

/**
 *
 * @author mpanagrosso
 */
public class User {
    String userName = "";
    String passWord = "";
    String fullName = "";


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    // TODO security level, privileges
    
    
    
    
    
    
}
