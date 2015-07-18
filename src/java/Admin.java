/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *Hold the data for a particular admin
 * @author bitsplease
 */
@ManagedBean
@SessionScoped
public class Admin implements Serializable {
    
    private String adminName;
    private String password;

    
    
    @ManagedProperty("#{userManager}")
    private UserManager userManager;
    
    @ManagedProperty("#{adminManager}")
    private AdminManager adminManager;
    

    /**
     * Creates a new instance of an Admin
     */
    public Admin() {
        System.out.println("Making Admin");

    }
    /**
     * Getter for username
     * @return username
     */
    public String getAdminName() { 
        return adminName;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Getter for password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    

    


    /**
     * Queries userManager to verify that user has
     * provided a correct username and password
     * @return success
     */
    public String login() {
        System.out.println("Doing some business logic here");
        //AdminData data = adminManager.find("Admin");
        AdminData data = getAdminManager().find(adminName);
        System.out.println("Looking for admin");
        System.out.println(adminName  + " " + password);
       
        if (data == null || !data.checkLogin(password)) {
            adminName="";
            password="";
            System.out.println("No such user found or password wrong");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Username or Password incorrect"));
            return null;
        }
        System.out.println("Login Success");
        getUserManager().saveBinary();
            return "admin";
    }
    
    /**
     * Adds a new user to userManager
     * @return login
     */
    public String addAdmin() {
        getAdminManager().addAdmins(adminName, password);
        
        return "userInfo";
    }
    
    /**
     * Queries userManager to verify that user has
     * provided a correct username and password.
     * If the username and password are accepted, then 
     * the username is removed from userManager
     * @return login
     */
    /*
    public String delete() {
        AdminData data = adminManager.find(username);
        
        if (data == null || !data.checkLogin(password)) {
            username="";
            password="";
            System.out.println("No such user found or password wrong");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Username or Password incorrect"));
            return null;
        } else {
            adminManager.removeAdmin(username, password);
        }
        return "login";
    }
    */
    
    /**
     * Connects userManager with User
     * @param userManager 
     */
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
    /**
     * Connects movieManager with User
     * @param adminManager 
     */
    public void setAdminManager(AdminManager adminManager) {
        this.adminManager = adminManager;
    }

    /**
     * @return the userManager
     */
    public UserManager getUserManager() {
        return userManager;
    }

    /**
     * @return the adminManager
     */
    public AdminManager getAdminManager() {
        return adminManager;
    }
    
    public ArrayList<UserData> getCurrentQuery(UserManager userManager) {
        return userManager.getCurrentQuery();
    }


    
   
}
