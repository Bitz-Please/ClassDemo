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
@ManagedBean (name = "adminManager")
@ApplicationScoped
public class AdminManager {
     
    private static Map<String, AdminData> admins = new HashMap<>();

    /**
     * Creates a new instance of UserManager
     */
    public AdminManager() {

        loadBinary();
    }
    /**
     * Generates default users to add to users HashMap
     */
    private void makeSomeAdmins() {
        admins.put("Admin", new AdminData("Admin", "pass"));

    }
    
    /**
     * Adds a new user to user HashMap
     * @param admin
     * @param pass 
     */
    public void addAdmins(String admin, String pass) {
        admins.put(admin, new AdminData(admin, pass));
        saveBinary();
    }
    
    /**
     * Removes an existing user form user HashMap
     * @param user
     * @param pass 
     */
    /*
    public void removeAdmin(String user, String pass) {
        users.remove(user);
    }
    */
	
    /**
     * Queries user HashMap and returns associated user data
     * @param adminname
     * @return userData
     */
    public AdminData find(String adminname) {
       System.out.println("Looking up user: " + adminname);
       return admins.get(adminname);
    }
    
    /**
     * Saves the binary files for persistent data in the project's Resources folder
     */
    public void saveBinary() {
        
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(getPath() + "resources/savedAdmins.bin"));
            os.writeObject(admins);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(AdminManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Loads the binary files for persistent data in the project's Resources folder
     */
    public void loadBinary() {
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(getPath() + "resources/savedAdmins.bin"));
            admins = (Map<String, AdminData>) is.readObject();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(AdminManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    



    

    /**
     * Getter for the UserMap
     * @return the UserMap
     */
    public Map<String, AdminData> getAdminMap() {
        return admins;
    }
    
    /**
     * Getter for the project's path
     * @return the project's current path
     */
    private String getPath() {
        String path = AdminManager.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        int last = path.lastIndexOf("ClassDemo");
        
        StringBuilder lastPart = new StringBuilder();
        
        for (int i = 0; i < last + 9; i++) {
            lastPart.append(path.charAt(i));
        }
        
        return lastPart.toString().replace("%20", " ") + "/";
    }
    
}
