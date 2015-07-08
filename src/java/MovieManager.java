
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
 *
 * @author megi
 */

@ManagedBean (name = "moviemanager")
@ApplicationScoped
public class MovieManager {
    
    private final String FILE_NAME; 
    private static Map<String, Movie> movies = new HashMap<>();
    private ArrayList<Movie> currentQuery;
    
    
    public MovieManager() {
        FILE_NAME = "movieData.dat";
        File file = new File(FILE_NAME);
        if (file.length() != 0) {
            loadData();
        }
    }
    
    
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
    
    
    public Movie getMovie(String title) {
        return movies.get(title);
    }
    
    public ArrayList<Movie> getCurrentQuery() {
        ArrayList<Movie> ret = new ArrayList<Movie>();
        for(Movie current : currentQuery) {
            ret.add(movies.get(current.getTitle()));
        }
        return ret;
        
    }
    
    
    /*
    public String callMovie(String title) {
        return movies.get(title).setMovieAndGo();
    } */
    
}
