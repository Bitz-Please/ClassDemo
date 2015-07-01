
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
 *
 * @author Zack
 */
@SessionScoped
@ManagedBean (name = "moviebean")
public class MovieBean implements Serializable {
    private Movie movie;
    private ArrayList<Movie> movies;
    
    public MovieBean() {
        System.out.println("Creating MovieBean!!");
    }
    
//    public void setId(String id) {
//        this.id = id;
//        System.out.println("Setting id to " + id);
//    }
//    
//    public String getId() {
//        return id;
//    }
    
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
        System.out.println("Settings movies to " + movies);
    }
    
    public String setMovieAndGo(Movie movie) {
        this.movie = movie;
        return "movie";
    }
    
    public Movie getMovie() {
        System.out.println("I'VE BEEN FOUND, MOVIE-------" + movie);
        return movie;
    }
    
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    
    public String getPoster() {
        String original = movie.getPosters().getProfile();
        int start = original.lastIndexOf("movie");
        StringBuilder lastPart = new StringBuilder();
        
        for (int i = start; i < original.length(); i++) {
            lastPart.append(original.charAt(i));
        }
        
        
        return "http://content6.flixster.com/" + lastPart.toString();
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
