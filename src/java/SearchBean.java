/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * A class that implements the search of a movie based on user input
 * @author bitsplease
 */
@ManagedBean (name = "searchbean")
@SessionScoped
public class SearchBean implements Serializable {
    
    
    private String search;
    private ArrayList<Movie> movies;
    
    /**
     * Creates the searchbean object
     */
    public SearchBean() {
        
    }
    
    /**
     * Searches for movies that match the search criteria
     * @return list of movies that match the criteria
     */
    public ArrayList<Movie> search(){
        RTRESTService rtService = new RTRESTService();
        setMovies(rtService.search(search));
        return movies;
    }

    /**
     * Gets what the user serached for
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * Sets the serach parameter
     * @param search the search to set
     */
    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * Get the movies that matched the search description
     * @return the movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * Get the searched movies
     * @param movies the movies to set
     */
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    
    
}
