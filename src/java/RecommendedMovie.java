/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *The recommended movie object that the recommender algorithm comes up with
 * @author Timothy
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RecommendedMovie {
    
    private Movie movie;
    private String rating;

    /**
     * Getter for the movie object
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Setter for the movie object
     * @param movie the movie to set
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Getter for the rating of the movie
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * Setter for the rating of the movie
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    
    
}
