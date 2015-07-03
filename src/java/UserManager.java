/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.*;

/**
 *
 * @author bitsplease
 */
@ManagedBean (name = "userManager")
@ApplicationScoped
public class UserManager {
     
    private static Map<String, UserData> users = new HashMap<>();

    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
        loadBinary();
    }
    /**
     * Generates default users to add to users HashMap
     */
    private void makeSomeUsers() {
        users.put("Bob", new UserData("Bob", "pass"));
        users.put("Sally", new UserData("Sally", "pass"));
        users.put("Fred", new UserData("Fred", "pass"));
        users.put("Timothy", new UserData("Timothy", "dani"));
        users.put("User", new UserData("User", "pass"));
    }
    
    /**
     * Adds a new user to user HashMap
     * @param user
     * @param pass 
     */
    public void addUsers(String user, String pass) {
        users.put(user, new UserData(user, pass));
        saveBinary();
    }
    
    /**
     * Removes an existing user form user HashMap
     * @param user
     * @param pass 
     */
    public void removeUser(String user, String pass) {
        users.remove(user);
    }
	
    /**
     * Queries user HashMap and returns associated user data
     * @param username
     * @return userData
     */
    UserData find(String username) {
       System.out.println("Looking up user: " + username);
       return users.get(username);
    }
    
    /**
     * Saves the binary files for persistent data in the project's Resources folder
     */
    public void saveBinary() {
        
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(getPath() + "resources/savedUsers.bin"));
            os.writeObject(users);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Loads the binary files for persistent data in the project's Resources folder
     */
    public void loadBinary() {
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(getPath() + "resources/savedUsers.bin"));
            users = (Map<String, UserData>) is.readObject();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gets user email from users
     * @return address
     */
    public String getEmail(String user) { 
        return users.get(user).getEmail();
    }
    
    /**
     * Gets user address from users
     * @return address
     */
    public String getAddress(String user) { 
        return users.get(user).getAddress();
    }
    
    /**
     * Gets user major from users
     * @return major
     */
    public String getMajor(String user) { 
        return users.get(user).getMajor();
    }
    
    /**
     * Gets user additional info from users
     * @return additionalInfo
     */
    public String getAdditionalInfo(String user) { 
        return users.get(user).getAdditionalInfo();
    }
    
    /**
     * Gets a particular user's rating of a particular movie
     * @param input the movie 
     * @param user the user 
     * @return 
     */
    public String getRating(Movie input, String user) {
        return users.get(user).getRating(input);
    }
    
    /**
     * sets the rating of a particular movie from a particular user
     * @param input the movie to be rated
     * @param user the user rating the movie
     * @param rating the rating
     */
    public void setRating(Movie input, String user, String rating) {
        System.out.println("Adding rating " + rating + " to movie " + input.getTitle());
        users.get(user).setRating(input, rating);
    }
    
    /**
     * Getter for the UserMap
     * @return the UserMap
     */
    public Map<String, UserData> getUserMap() {
        return users;
    }
    
    /**
     * Getter for the project's path
     * @return the project's current path
     */
    private String getPath() {
        String path = UserManager.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        int last = path.lastIndexOf("ClassDemo");
        
        StringBuilder lastPart = new StringBuilder();
        
        for (int i = 0; i < last + 9; i++) {
            lastPart.append(path.charAt(i));
        }
        
        return lastPart.toString().replace("%20", " ") + "/";
    }
    
}
