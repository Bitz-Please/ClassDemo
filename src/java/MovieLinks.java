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

@Generated("org.jsonschema2pojo")

public class MovieLinks {
    
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
     * @return the self
     */
    public String getSelf() {
        return self;
    }

    /**
     * @param self the self to set
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * @return the alternate
     */
    public String getAlternate() {
        return alternate;
    }

    /**
     * @param alternate the alternate to set
     */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    /**
     * @return the cast
     */
    public String getCast() {
        return cast;
    }

    /**
     * @param cast the cast to set
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

    /**
     * @return the reviews
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * @param reviews the reviews to set
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    /**
     * @return the similar
     */
    public String getSimilar() {
        return similar;
    }

    /**
     * @param similar the similar to set
     */
    public void setSimilar(String similar) {
        this.similar = similar;
    }
}
