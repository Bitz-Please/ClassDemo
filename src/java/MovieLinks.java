/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joesadler
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")

public class MovieLinks implements Serializable {
    
    @Expose
    private String self;
    @Expose
    private String alternate;
    @Expose
    private String cast;
    @Expose
    private String reviews;
    @Expose
    private String similar;

    /**
     * Getter for the movie link
     * @return the self
     */
    public String getSelf() {
        return self;
    }

    /**
     * Setter for the movie link
     * @param self the self to set
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * Getter for the alternate link
     * @return the alternate
     */
    public String getAlternate() {
        return alternate;
    }

    /**
     * Setter for the alternate link
     * @param alternate the alternate to set
     */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    /**
     * Getter for the cast of the movie
     * @return the cast
     */
    public String getCast() {
        return cast;
    }

    /**
     * Setter for the cast of the movie
     * @param cast the cast to set
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

    /**
     * Getter for the reviews of the movie
     * @return the reviews
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * Setter for the reviews of a movie
     * @param reviews the reviews to set
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    /**
     * Getter for similar movies
     * @return the similar
     */
    public String getSimilar() {
        return similar;
    }

    /**
     * Setter for similar movies
     * @param similar the similar to set
     */
    public void setSimilar(String similar) {
        this.similar = similar;
    }
}
