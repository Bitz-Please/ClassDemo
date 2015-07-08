/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class that stores the ratings of a particular movie
 * @author joesadler
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
        
class Ratings implements Serializable {
    
    @Expose
    private String critics_rating;
    @Expose
    private Integer critics_score;
    @Expose
    private String audience_rating;
    @Expose
    private Integer audience_score;

    /**
     * @return the critics_rating
     */
    public String getCritics_rating() {
        return critics_rating;
    }

    /**
     * @param critics_rating the critics_rating to set
     */
    public void setCritics_rating(String critics_rating) {
        this.critics_rating = critics_rating;
    }

    /**
     * @return the critic_score
     */
    public Integer getCritics_score() {
        System.out.println("I'VE BEEN FOUND, SCORE-----" + critics_score);
        return (critics_score / 20);
    }

    /**
     * @param critic_score the critic_score to set
     */
    public void setCritics_score(Integer critic_score) {
        this.critics_score = critic_score;
    }
    
    /**
     * @return the audience_rating
     */
    public String getAudience_rating() {
        return audience_rating;
    }

    /**
     * @param audience_rating the audience_rating to set
     */
    public void setAudience_rating(String audience_rating) {
        this.audience_rating = audience_rating;
    }

    /**
     * @return the audience_score
     */
    public Integer getAudience_score() {
        return audience_score;
    }

    /**
     * @param audience_score the audience_score to set
     */
    public void setAudience_score(Integer audience_score) {
        this.audience_score = audience_score;
    }
    
}
