
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
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

@ManagedBean
@ApplicationScoped
public class UserData implements Serializable {
    
    private String name;
    private String password;
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
        this.setEmail(email);
        this.setAddress(address);
        this.setMajor(major);
        this.setAdditionalInfo(additionalInfo);
    }
    
    /**
     * Checks to see if the user trying to login
     * has provided the correct password
     * @param password
     * @return true if password is correct, false otherwise
     */
    boolean checkLogin(String password) {
        return password.equals(this.getPassword());
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
        System.out.println("MY USER OWNER IS " + getName());
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @param additionalInfo the additionalInfo to set
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * @param personalRatings the personalRatings to set
     */
    public void setPersonalRatings(Map<Movie, String> personalRatings) {
        this.personalRatings = personalRatings;
    }
    
}
