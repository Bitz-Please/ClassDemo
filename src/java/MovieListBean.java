
/**
 *
 * @author joesadler
 */

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean (name = "movielistbean")

public class MovieListBean {
    
    private APIService currentAPI;
    private String search;
    MovieManager movieManager;
    ArrayList<Item> movies;
    
    public MovieListBean() {
        currentAPI = new RTRESTService();
        movieManager = new MovieManager();
    }
    
    public ArrayList<Item> getTheaterMovies() {
        movies = currentAPI.getNewOpenings();
        movieManager.addMovie(movies);
        return movies;
    }
    
    public ArrayList<Item> getDvdMovies() {
        movies = currentAPI.getNewReleases();
        movieManager.addMovie(movies);
        return movies;
    }
     
    public ArrayList<Item> getSearchMovies() {
        movies = currentAPI.search(search);
        movieManager.addMovie(movies);
        return movies;
    }
    
    /**
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(String search) {
        this.search = search;
    }
    
}
