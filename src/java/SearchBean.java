/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joesadler
 */

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name = "searchbean")
@SessionScoped
public class SearchBean implements Serializable {
    
    
    private String search;
    private ArrayList<Movie> movies;
    
    public SearchBean() {
        
    }
    
    public ArrayList<Movie> search(){
        RTRESTService rtService = new RTRESTService();
        setMovies(rtService.search(search));
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

    /**
     * @return the movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies the movies to set
     */
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    
    
}
