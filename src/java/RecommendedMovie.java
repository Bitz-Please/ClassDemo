
import java.util.Map;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *The recommended movie object that the recommender algorithm comes up with
 * @author Timothy
 */


public class RecommendedMovie {
    
    private Movie movie;
    private int userRatings;
    private double avgRating;

    public RecommendedMovie (Map.Entry<Movie, String> input) {
        this.movie = input.getKey();
        this.avgRating = Double.parseDouble(input.getValue());
        userRatings++;
    }
    
    
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
     * Adds a unique rating & username entry to 
     * a movie's ratings. Checks to see if the user
     * has rated the movie before or not and acts 
     * accordingly.
     * @param rating rating of movie
     * @param username user responsible for rating
     */
    public void addRating(String rating) {
        userRatings++;
        double newRating = Double.parseDouble(rating);
        avgRating = (((getAvgRating() * (getUserRatings() - 1)) + newRating) / getUserRatings());
    }

    /**
     * @return the avgRating
     */
    public double getAvgRating() {
        return avgRating;
    }

    /**
     * @return the userRatings
     */
    public int getUserRatings() {
        return userRatings;
    }
    
}
