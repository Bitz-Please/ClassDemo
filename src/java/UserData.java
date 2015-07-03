
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bitsplease
 */
class UserData implements Serializable {
    private String name;
    private String password;
    private String email;
    private String address;
    private String major;
    private String additionalInfo;
    private Map<Movie, String> personalRatings = new HashMap<>();
    
    /**
     * Creates a new instance of UserData
     */
    UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    /**
     * Updates user information 
     * @param email
     * @param address
     * @param major
     * @param additionalInfo 
     */
    void updateData(String email, String address, String major, String additionalInfo) {
        this.email = email;
        this.address = address;
        this.major = major;
        this.additionalInfo = additionalInfo;
    }
    
    /**
     * Checks to see if the user trying to login
     * has provided the correct password
     * @param password
     * @return true if password is correct, false otherwise
     */
    boolean checkLogin(String password) {
        return password.equals(this.password);
    }
    
    /**
     * Getter for user email
     * @return email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Getter for user address
     * @return address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Getter for user major
     * @return major
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * Getter for additional information about user
     * @return additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    
    public String getRating(Movie input) {
        String rating = getPersonalRatings().get(input);
        System.out.println("MY USER OWNER IS " + name);
        if (rating != null) {
            return rating;
        } else {
            return "0";
        }   
    }
    
    public void setRating(Movie input, String rating) {
        System.out.println("Adding rating " + rating + " to movie " + input.getTitle());
        getPersonalRatings().put(input, rating);
        
    }

    /**
     * @return the personalRatings
     */
    public Map<Movie, String> getPersonalRatings() {
        return personalRatings;
    }
    
   
    
}
