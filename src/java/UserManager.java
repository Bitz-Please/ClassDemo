/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author robertwaters
 */
@ManagedBean (name = "userManager")
@ApplicationScoped
public class UserManager {
    
    private Map<String, UserData> users = new HashMap<>();

    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
        System.out.println("Creating User Manager");
        makeSomeUsers();
    }

    private void makeSomeUsers() {
        users.put("Bob", new UserData("Bob", "pass"));
        users.put("Sally", new UserData("Sally", "pass"));
        users.put("Fred", new UserData("Fred", "pass"));
        users.put("Timothy", new UserData("Timothy", "dani"));
  
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
    
}
