
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Stores the data of the current user
 * @author bitsplease
 */
class UserData implements Serializable {
    
    @Expose
    private String name;
    @Expose
    private String password;
    @Expose
    private String email;
    private String address;
    private String major;
    private String additionalInfo;
    private Map<Movie, String> personalRatings = new HashMap<>();
    
    /**
     * Creates a new instance of UserData
     * @param name the name of the user
     * @param password password of the user account
     */
    UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    /**
     * Updates user information 
     * @param email the email of the user
     * @param address the address of the user
     * @param major the major of the user
     * @param additionalInfo any extra information about the user
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
    
    /**
     * Gets the user's rating of a particular movie
     * @param input the movie object to get the rating of
     * @return the rating of the movie
     */    
    public String getRating(Movie input) {
        String rating = getPersonalRatings().get(input);
        System.out.println("MY USER OWNER IS " + name);
        if (rating != null) {
            return rating;
        } else {
            return "0";
        }   
    }
    
    /**
     * Sets the user's rating on a particular movie
     * @param input the movie to be rated
     * @param rating the rating
     */
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
    
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
   
    
}
