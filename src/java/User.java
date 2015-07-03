/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *Hold the data for a particular user
 * @author bitsplease
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
    /**
     * Getter for username
     * @return username
     */
    public String getUsername() { 
        return username;
    }
    
    /**
     * Getter for password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    //The values for 'email', 'address', 'major', and 'additional information' 
    //live in a 'UserData' object which is stored in a static hash map, which 
    //lives in a 'UserManager'. The getters for these attributes pull the data 
    //from that hash map via call to 'userManager'. These getters are called
    //implictly by 'profile.xhtlm' and 'userInfo.xhtml' to display user info.
    
    
    /**
     * Gets user email from userManager
     * @return email
     */
    public String getEmail() { 
        return userManager.getEmail(username);
    }
    
    /**
     * Gets user address from userManager
     * @return address
     */
    public String getAddress() { 
        return userManager.getAddress(username);
    }
    
    /**
     * Gets user major from userManager
     * @return major
     */
    public String getMajor() { 
        return userManager.getMajor(username);
    }
    
    /**
     * Gets user additional info from userManager
     * @return additionalInfo
     */
    public String getAdditionalInfo() { 
        return userManager.getAdditionalInfo(username);
    }
    
    /**
     * Setter for username
     * @param username 
     */
    public void setUsername(String username) {
        System.out.println("Setting name to " + username);
        this.username = username;
    }
    
    /**
     * Setter for password
     * @param password 
     */
    public void setPassword(String password) {
        System.out.println("Setting password to " + password);
        this.password = password;
    }
    
    /**
     * Setter for email
     * @param email 
     */
    public void setEmail(String email) {
        System.out.println("Setting email to " + email);
        this.email = email;
    }
    
    /**
     * Setter for address
     * @param address
     */
    public void setAddress(String address) {
        System.out.println("Setting address to " + address);
        this.address = address;
    }
    
    /**
     * Setter for major
     * @param major 
     */
    public void setMajor(String major) {
        System.out.println("Setting major to " + major);
        this.major = major;
    }
    
    /**
     * Setter for additonalInfo
     * @param additionalInfo
     */
    public void setAdditionalInfo(String additionalInfo) {
        System.out.println("Setting Additional Info to " + additionalInfo);
        this.additionalInfo = additionalInfo;
    }
    
    /**
     * Queries userManager to verify that user has
     * provided a correct username and password
     * @return success
     */
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
            return "home_new"; //"home"
    }
    
    /**
     * Adds a new user to userManager
     * @return login
     */
    public String addUser() {
        userManager.addUsers(username, password);
        
        return "userInfo";
    }
    
    /**
     * Queries userManager to verify that user has
     * provided a correct username and password.
     * If the username and password are accepted, then 
     * the username is removed from userManager
     * @return login
     */
    public String delete() {
        UserData data = userManager.find(username);
        
        if (data == null || !data.checkLogin(password)) {
            username="";
            password="";
            System.out.println("No such user found or password wrong");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Username or Password incorrect"));
            return null;
        } else {
            userManager.removeUser(username, password);
        }
        return "login";
    }
    
    /**
     * Connects userManager with User
     * @param userManager 
     */
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
    /**
     * Provides userManager with user data to store
     * @return profile
     */
    public String updateUserData() {
        UserData data = userManager.find(username);
        data.updateData(email, address, major, additionalInfo);
        userManager.saveData();
        return "profile_new";
    }
    
    /**
     * 
     * @param input
     * @return 
     */
    public String getMovieRating(Movie input) {
        System.out.println("Getting rating for movie " + input.getTitle() + " for user " + username);
        return userManager.getRating(input, username);
    }

    /**
     * 
     * @param input
     * @param rating
     * @return 
     */
    public String addRating(Movie input, String rating) {
        System.out.println("Adding rating " + rating + " to movie " + input.getTitle());
        userManager.setRating(input, username, rating);
        input.addRatings(rating, username);
        userManager.saveData();
        return "movie";
        
    }
    
    /*
    public String getRating(Movie input) {
        
    }
    */
}
