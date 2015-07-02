/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author bitsplease
 */
@ManagedBean (name = "userManager")
@ApplicationScoped
public class UserManager {
    
    private final String FILE_NAME; 
    private static Map<String, UserData> users = new HashMap<>();

    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
        FILE_NAME = "userData.dat";
        File file = new File(FILE_NAME);
        if (file.length() != 0) {
            loadData();
        } else {
            System.out.println("Creating User Manager");
            makeSomeUsers();
        }
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
        saveData();
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
     * Writes user HashMap to a data file
     */
    public void saveData() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
            System.out.println("saved");
        } catch(Exception e) {
            System.out.println("File not found");
        }
           
    }
    
     /**
     * Sets 'users' instance variable to object read from data file  
     */
    public void loadData() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (HashMap) ois.readObject();
            
        } catch(Exception e) {
            System.out.println("File not found");
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
    
    public String getRating(Movie input, String user) {
        return users.get(user).getRating(input);
    }
    
    public void setRating(Movie input, String user, String rating) {
        System.out.println("Adding rating " + rating + " to movie " + input.getTitle());
        users.get(user).setRating(input, rating);
    }
    
    public Map<String, UserData> getUserMap() {
        return users;
    }
    
}
