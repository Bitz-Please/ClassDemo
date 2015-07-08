
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Stores the data of the current user
 * @author bitsplease
 */
class AdminData implements Serializable {
    private String adminName;
    private String password;

    
    /**
     * Creates a new instance of UserData
     * @param name the name of the user
     * @param password password of the user account
     */
    AdminData(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }


    /**
     * Checks to see if the user trying to login
     * has provided the correct password
     * @param password
     * @return true if password is correct, false otherwise
     */
    public boolean checkLogin(String password) {
        return password.equals(this.password);
    }
    
    public String getAdminName() {
        return adminName;
    }
    
    public String getPasswrod() {
        return password;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   
    
}
