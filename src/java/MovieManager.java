
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Class that manages the movies rated by the users
 * @author megi
 */

@ManagedBean (name = "moviemanager")
@ApplicationScoped
public class MovieManager {
    
    private final String FILE_NAME; 
    private static Map<String, Movie> movies = new HashMap<>();
    private ArrayList<Movie> currentQuery;
    //private static Map<String, 
    
    /**
     * Creates the movie manager object
     */
    public MovieManager() {
        FILE_NAME = "movieData.dat";
        File file = new File(FILE_NAME);
        if (file.length() != 0) {
            loadData();
        }
    }
    
    /**
     * Adds movies to the existing list of movies
     * @param newMovies the movies to add
     * @return the results of the query
     */
    public String addMovie(ArrayList<Movie> newMovies) {

        currentQuery = newMovies;
        for(Movie mov : newMovies) {
            if (!this.movies.containsKey(mov.getTitle())) {
                this.movies.put(mov.getTitle() ,mov);
                saveData();
            } 
        }
        
        return "query_results";
    }
    
    
    /**
     * Saves the rated movies
     */
    public void saveData() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(movies);
            oos.close();
            fos.close();
        } catch(Exception e) {
            System.out.println("File not found");
        }
           
    }
    
    /**
     * laods the existing rated movies 
     */
    public void loadData() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            movies = (HashMap) ois.readObject();
        } catch(Exception e) {
            System.out.println("File not found");
        }
    }
    
    
    /**
     * Gets a particular movie
     * @param title the title of the movie
     * @return the movie
     */
    public Movie getMovie(String title) {
        return movies.get(title);
    }
    
    /**
     * Getter for the current query
     * @return the current query of movies
     */
    public ArrayList<Movie> getCurrentQuery() {
        ArrayList<Movie> ret = new ArrayList<Movie>();
        for(Movie current : currentQuery) {
            ret.add(movies.get(current.getTitle()));
        }
        return ret;
        
    }
    
   
    public void addMajorRating(String major, Movie ratedMovie, String rating) {
        
    }
    
    /*
    public String callMovie(String title) {
        return movies.get(title).setMovieAndGo();
    } */
    
}
