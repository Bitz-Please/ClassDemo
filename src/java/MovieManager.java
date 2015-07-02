
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;
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
public final class MovieManager {
    
    private static Map<String, Movie> movies = new HashMap<>();
    private ArrayList<Movie> currentQuery;
    
    
    public MovieManager() {
        loadBinary();
    }
    
    
    public String addMovie(ArrayList<Movie> newMovies) {

        currentQuery = newMovies;
        for(Movie mov : newMovies) {
            if (!this.movies.containsKey(mov.getTitle())) {
                this.movies.put(mov.getTitle() ,mov);
                saveBinary();
            } 
        }
        
        return "query_results";
    }
    
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
    
//    
//    public void saveData() {
//        FileOutputStream fos;
//        try {
//            fos = new FileOutputStream(FILE_NAME);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(movies);
//            oos.close();
//            fos.close();
//        } catch(Exception e) {
//            System.out.println("File not found");
//        }
//           
//    }
//    
//    public void loadData() {
//        FileInputStream fis;
//        try {
//            fis = new FileInputStream(FILE_NAME);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            movies = (HashMap) ois.readObject();
//        } catch(Exception e) {
//            System.out.println("File not found");
//        }
//    }
    
    
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
    
    private String getPath() {
        String path = UserManager.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        int last = path.lastIndexOf("ClassDemo");
        
        StringBuilder lastPart = new StringBuilder();
        
        for (int i = 0; i < last + 9; i++) {
            lastPart.append(path.charAt(i));
        }
        
        return lastPart.toString().replace("%20", " ") + "/";
    }
    
    
    /*
    public String callMovie(String title) {
        return movies.get(title).setMovieAndGo();
    } */
    
}
