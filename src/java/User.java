/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author robertwaters
 */
@ManagedBean
@SessionScoped
public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private String address;
    private String major;
    private String additionalInfo;
    
    @ManagedProperty("#{userManager}")
    private UserManager userManager;
    

    /**
     * Creates a new instance of User
     */
    public User() {
        System.out.println("Making user");
        //email = userManager.find(username).getEmail();
        //address = userManager.find(username).getAddress();
    }
    
    public String getUsername() { 
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getEmail() { 
        return userManager.find(username).getEmail();
    }
    
    public String getAddress() { 
        return userManager.find(username).getAddress();
    }
    
    public String getMajor() { 
        return userManager.find(username).getMajor();
    }
    
    public String getAdditionalInfo() { 
        return userManager.find(username).getAdditionalInfo();
    }
    
    public void setUsername(String u) {
        System.out.println("Setting name to " + u);
        username = u;
    }
    
    public void setPassword(String p) {
        System.out.println("Setting password to " + p);
        password = p;
    }
    
    public void setEmail(String e) {
        System.out.println("Setting email to " + e);
        email = e;
    }
    
    public void setAddress(String a) {
        System.out.println("Setting address to " + a);
        address = a;
    }
    
    public void setMajor(String m) {
        System.out.println("Setting major to " + m);
        major = m;
    }
    
    public void setAdditionalInfo(String ai) {
        System.out.println("Setting Additional Info to " + ai);
        additionalInfo = ai;
    }
    
    public String login() {
        System.out.println("Doing some business logic here");
        UserData data = userManager.find(username);
        
        if (data == null || !data.checkLogin(password)) {
            username="";
            password="";
            System.out.println("No such user found or password wrong");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Username or Password incorrect"));
            return null;
        }
        System.out.println("Login Success");
            return "success";
    }
    
    public String addUser() {
        userManager.addUsers(username, password);
        userManager.saveData();
        return "login";
    }
    
    public String loginPage() {
        return "login";
    }
    
    public String registerPage() {
        return "register";
    }
    
    public void setUserManager(UserManager um) {
        userManager = um;
    }
    
    public String updateUserData() {
        UserData data = userManager.find(username);
        data.updateData(email, address, major, additionalInfo);
        userManager.saveData();
        return "success";
    }

}
