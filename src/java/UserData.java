
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robertwaters
 */
class UserData {
    private String name;
    private String password;
    private String email;
    private String address;
    private String major;
    private String additionalInfo;
    
    UserData(String nm, String ps) {
        name = nm;
        password = ps;
    }
    
    void updateData(String em, String address, String major, String additionalInfo) {
        this.email = em;
        this.address = address;
        this.major = major;
        this.additionalInfo = additionalInfo;
    }
    
    boolean checkLogin(String p) {
        return p.equals(password);
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getMajor() {
        return major;
    }
    
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    
}
