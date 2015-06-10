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
 * @author robertwaters
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

    private void makeSomeUsers() {
        users.put("Bob", new UserData("Bob", "pass"));
        users.put("Sally", new UserData("Sally", "pass"));
        users.put("Fred", new UserData("Fred", "pass"));
        users.put("Timothy", new UserData("Timothy", "dani"));
        users.put("User", new UserData("User", "pass"));
  
    }
    
    public void addUsers(String user, String pass) {
        users.put(user, new UserData(user, pass));
    }
    
    public void removeUser(String user, String pass) {
        users.remove(user);
    }
	
    UserData find(String username) {
       System.out.println("Looking up user: f" + username);
       return users.get(username);
    }
    
    public void saveData() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
        } catch(Exception e) {
            System.out.println("File not found");
        }
           
    }
    
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
    
}
