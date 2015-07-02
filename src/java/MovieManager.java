
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

@ManagedBean (name = "movieManager")
@ApplicationScoped
public class MovieManager {
    
    private final String FILE_NAME; 
    private static Map<String, MovieBean> movies = new HashMap<>();
    
    
    public MovieManager() {
        FILE_NAME = "movieData.dat";
        File file = new File(FILE_NAME);
        if (file.length() != 0) {
            loadData();
    }
    }
    
    
    public String addMovie(String title, Movie mov) {
        
        
        MovieBean m = new MovieBean(mov);
        if (!movies.containsKey(title)) {
            movies.put(title,m);
            saveData();
        }
        
        return callMovie(title);
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
        MovieBean mov = movies.get(title);
        return mov.getMovie();
    }
    
    
    
    public String callMovie(String title) {
        return movies.get(title).setMovieAndGo();
    }
    
}
