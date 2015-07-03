/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class that manages the posters of a movie
 * @author joesadler
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Generated("org.jsonschema2pojo")
@ManagedBean (name="posters")
@SessionScoped
class Posters implements Serializable {
    
    @Expose
    private String thumbnail;
    @Expose
    private String profile;
    @Expose
    private String detailed;
    @Expose
    private String original;

    /**
     * Getter for the thumbnail of the movie
     * @return the thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Setter for the thumbnail of the movie
     * @param thumbnail the thumbnail to set
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * getter for the profile of the movie
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * setter for the profile of the movie
     * @param profile the profile to set
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * getter for the details of the movie
     * @return the detailed
     */
    public String getDetailed() {
        return detailed;
    }

    /**
     * setter for the details of the movie
     * @param detailed the detailed to set
     */
    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    /**
     * @return the original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * @param original the original to set
     */
    public void setOriginal(String original) {
        this.original = original;
    }
    
}
