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
    
    private static Map<String, UserData> users = new HashMap<>();

    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
      
        File file = new File("userData.dat");
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
    
    UserData find(String username) {
       System.out.println("Looking up user: " + username);
       return users.get(username);
    }
    
    public void saveData() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("userData.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
        } catch(Exception e) {
            System.out.println(e);
        }
           
    }
    
    public void loadData() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("userData.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (HashMap) ois.readObject();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
