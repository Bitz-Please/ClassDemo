
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Allows communication between pages with links to movies
 * @author Zack
 */
@SessionScoped
@ManagedBean (name = "moviebean")
public class MovieBean implements Serializable {
    private Movie movie;
    
    /**
     * Constructs a new MOvieBean object
     */
    public MovieBean() {
        System.out.println("Creating MovieBean!!");
    }
    
    /**
     * Called from CommandLinks to set movie attribute and go to the movie page
     * @param movie
     * @return 
     */
    public String setMovieAndGo(Movie movie) {
        this.movie = movie;
        return "movie";
    }
    
    /**
     * @return the movie
     */
    public Movie getMovie() {
        System.out.println("I'VE BEEN FOUND, MOVIE-------" + movie);
        return movie;
    }
    
    /**
     * @return the full res poster URL
     */
    public String getPoster() {
        String original = movie.getPosters().getProfile();
        int start = original.lastIndexOf("movie");
        StringBuilder lastPart = new StringBuilder();
        
        if (start > 0) {
        
            for (int i = start; i < original.length(); i++) {
                lastPart.append(original.charAt(i));
            }


            return "http://content6.flixster.com/" + lastPart.toString();
        } else {
            return "PosterNotFound.png";
        }
    }
    
    public String getRatings() {
        Ratings rating = movie.getRatings();
        if (rating != null) {
            return "" + rating.getCritics_score();
        } else {
            System.out.println("FAILURE");
            return "5";
        }
        
    }
}
