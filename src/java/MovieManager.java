
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.*;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

 /*
 *Class that manages the movies rated by the users
 * @author megi
 */

@ManagedBean (name = "movieManager")
@ApplicationScoped
public class MovieManager implements Serializable {
     
    private final String FILE_NAME; 
    private static Map<String, Movie> movies = new HashMap<>();
    private static ArrayList<Movie> currentQuery;
    private static String currentRecommendation;
    
    /**
     * Creates the movie manager object
     */
    public MovieManager() {
        FILE_NAME = "movieData.dat";
        File file = new File(FILE_NAME);
        if (file.length() != 0) {
            loadBinary();
        }
    }
    
    /**
     * Adds movies to the existing list of movies
     * @param newMovies the movies to add
     * @return the results of the query
     */
    public void addMovie(ArrayList<Movie> newMovies) {

        currentQuery = newMovies;
        for(Movie mov : newMovies) {
            if (!this.movies.containsKey(mov.getTitle())) {
                this.movies.put(mov.getTitle() ,mov);
                saveBinary();
            } 
        }
    }

    /**
     * Saves the persistent data in the project's Resources folder
     */
    public void saveBinary() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(getPath() + "resources/savedMovies.bin"));
            os.writeObject(movies);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Loads the persistent data in the project's Resources folder
     */
    public void loadBinary() {
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(getPath() + "resources/savedMovies.bin"));
            movies = (Map<String, Movie>) is.readObject();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
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
        ArrayList<Movie> ret = new ArrayList<>();
        for(Movie current : currentQuery) {
            ret.add(movies.get(current.getTitle()));
        }
        return ret;
        
    }

    /**
     * Returns the recommended movies
     * @param manage the UserManager class
     * @return the set of movies to recommend the user
     */
    public Set<Map.Entry<Movie, RecommendedMovie>> getRecommended(UserManager manage) {
        // Get all users
        Map<String, UserData> usersTemp = manage.getUserMap();
        Set<Map.Entry<String, UserData>> allUsers = usersTemp.entrySet();
        
        ArrayList<Map<Movie, String>> ratedMoviesByMajor = new ArrayList<>();
        
        // Filter out only users with a major
        for (Map.Entry<String, UserData> current : allUsers) {
            if (current.getValue().getMajor().equals(currentRecommendation)) {
                ratedMoviesByMajor.add(current.getValue().getPersonalRatings());
            }
        }
        
        // Start building new list.
        ArrayList<Movie> currentMovies = new ArrayList<Movie>();
        Map<Movie, RecommendedMovie> ret = new HashMap<>();
        
        for (Map<Movie, String> current: ratedMoviesByMajor) {
            Set<Map.Entry<Movie, String>> individualRatings = current.entrySet();
            
            
            for (Map.Entry<Movie, String> individualMovie : individualRatings) {
                if (!currentMovies.contains(individualMovie.getKey())) {
                    currentMovies.add(individualMovie.getKey());
                    ret.put(individualMovie.getKey(), new RecommendedMovie(individualMovie));
                } else {
                    ret.get(individualMovie.getKey()).addRating(individualMovie.getValue());
                }
            }
        
        }
        
        
        
        return ret.entrySet();
    }
    
    
    /*
    public String callMovie(String title) {
        return movies.get(title).setMovieAndGo();
    } */
    
    
    /**
     * @return the currentRecommendation
     */
    public String getCurrentRecommendation() {
        return currentRecommendation;
    }

    /**
     * @param currentRecommendation the currentRecommendation to set
     */
    public void setCurrentRecommendation(String currentRecommendation) {
        this.currentRecommendation = currentRecommendation;
    }
    
    /**
     * Gets the current working path of the project
     * @return the path of the project
     */
    private String getPath() {
        String path = UserManager.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        int last = path.lastIndexOf("ClassDemo");
        
        StringBuilder lastPart = new StringBuilder();
        
        for (int i = 0; i < last + 9; i++) {
            lastPart.append(path.charAt(i));
        }
        
        return lastPart.toString().replace("%20", " ") + "/";
    } 
}
