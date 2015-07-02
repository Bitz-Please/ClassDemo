/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joesadler
 */

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@Generated("org.jsonschema2pojo")
@ManagedBean
@SessionScoped
public class Movie {
    
    @Expose
    private String id;
    @Expose
    private String title;
    @Expose
    private Integer year;
    @Expose
    private String mpaa_rating;
    @Expose
    private Integer runtime;
    @Expose
    private String critics_consensus;
    @Expose
    private ReleaseDates release_dates;
    @Expose
    private Ratings ratings;
    @Expose
    private String synopsis;
    @Expose
    private Posters posters;
    @Expose
    private ArrayList<Actor> abridged_cast;
    @Expose
    private AltIds alternate_ids;
    @Expose
    private MovieLinks links;
    
    private double avgRating = 0;
    private int userRatings = 0;
    private Map<String, Double> userCheck = new HashMap<>();

    public Movie() {
        System.out.println("Creating Movie");
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * @return the mpaa_rating
     */
    public String getMpaa_rating() {
        return mpaa_rating;
    }

    /**
     * @param mpaa_rating the mpaa_rating to set
     */
    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    /**
     * @return the runtime
     */
    public Integer getRuntime() {
        return runtime;
    }

    /**
     * @param runtime the runtime to set
     */
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
    
    /**
     * @return the critics_consensus
     */
    public String getCritics_consensus() {
        return critics_consensus;
    }

    /**
     * @param critics_consensus the critics_consensus to set
     */
    public void setCritics_consensus(String critics_consensus) {
        this.critics_consensus = critics_consensus;
    }

    /**
     * @return the release_dates
     */
    public ReleaseDates getRelease_dates() {
        return release_dates;
    }

    /**
     * @param release_dates the release_dates to set
     */
    public void setRelease_dates(ReleaseDates release_dates) {
        this.release_dates = release_dates;
    }
    
    /**
     * @return the ratings
     */
    public Ratings getRatings() {
        System.out.println("I'VE BEEN FOUND, RATING ----" + ratings);
        return ratings;
    }

    /**
     * @param ratings the ratings to set
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }
    
    /**
     * @return the synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * @param synopsis the synopsis to set
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * @return the posters
     */
    public Posters getPosters() {
        return posters;
    }

    /**
     * @param posters the posters to set
     */
    public void setPosters(Posters posters) {
        this.posters = posters;
    }
    
    /**
     * @return the abridged_cast
     */
    public ArrayList<Actor> getAbridged_cast() {
        return abridged_cast;
    }

    /**
     * @param abridged_cast the abridged_cast to set
     */
    public void setAbridged_cast(ArrayList<Actor> abridged_cast) {
        this.abridged_cast = abridged_cast;
    }
    
    /**
     * @return the alternate_ids
     */
    public AltIds getAlternate_ids() {
        return alternate_ids;
    }

    /**
     * @param alternate_ids the alternate_ids to set
     */
    public void setAlternate_ids(AltIds alternate_ids) {
        this.alternate_ids = alternate_ids;
    }
    
    /**
     * @return the links
     */
    public MovieLinks getLinks() {
        return links;
    }

    /**
     * @param links the links to set
     */
    public void setLinks(MovieLinks links) {
        this.links = links;
    }
    
    public String getPoster() {
        String original = getPosters().getProfile();
        int start = original.lastIndexOf("movie");
        StringBuilder lastPart = new StringBuilder();
        
        for (int i = start; i < original.length() - 7; i++) {
            lastPart.append(original.charAt(i));
        }
        
        System.out.println("http://content6.flixster.com/" + lastPart.toString() + "det.jpg");
        
        return "http://content6.flixster.com/" + lastPart.toString() + "ori.jpg";
    }
    
    /**
     * Adds a unique rating & username entry to 
     * a movie's ratings. Checks to see if the user
     * has rated the movie before or not and acts 
     * accordingly.
     * @param rating rating of movie
     * @param username user responsible for rating
     */
    public void addRatings(String rating, String username) {
        
        Double oldRating = userCheck.get(username);
        if (oldRating == null) {
            userRatings++;
            double newRating = Double.parseDouble(rating);
            avgRating = ((avgRating * (userRatings - 1)) + newRating) / userRatings;
            userCheck.put(username, newRating);
        } else {
            double newRating = Double.parseDouble(rating);
            avgRating = ((avgRating * userRatings) - oldRating + newRating) / userRatings;
            userCheck.put(username, newRating);
        }
    }
    
    /**
     * @return Average Rating of the movie
     */
    public Double getAvgRating() {
        return avgRating;
    }
    
    public int getNumRatings() {
        return userRatings;
    }
}
