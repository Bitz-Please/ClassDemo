
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
    
    private RTRESTService rtService;
    private String search;
    MovieManager movieManager;
    ArrayList<Movie> movies;
    
    public MovieListBean() {
        rtService = new RTRESTService();
        movieManager = new MovieManager();
    }
    
    public ArrayList<Movie> getTheaterMovies() {
        movies = rtService.getTheaterMovies();
        movieManager.addMovie(movies);
        return movies;
    }
    
    public ArrayList<Movie> getDvdMovies() {
        movies = rtService.getDvdMovies();
        movieManager.addMovie(movies);
        return movies;
    }
     
    public ArrayList<Movie> getSearchMovies() {
        movies = rtService.search(search);
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
