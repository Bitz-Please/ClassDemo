/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joesadler
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class RTResponse {
    
    @Expose
    private int total;
    @Expose
    private List<Movie> movies;
    @Expose
    private Links links;
    @Expose
    private String link_template;

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies the movies to set
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * @return the links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * @param links the links to set
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    /**
     * @return the link_template
     */
    public String getLink_template() {
        return link_template;
    }

    /**
     * @param link_template the link_template to set
     */
    public void setLink_template(String link_template) {
        this.link_template = link_template;
    }
    
}
