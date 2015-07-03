/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *The class for the movie object that holds information about a particular movie
 * @author joesadler
 */

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@Generated("org.jsonschema2pojo")
@ManagedBean
@SessionScoped
public class Movie implements Serializable, Comparable{
    
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
    private int teach = 0;

     /**
     * Creates the movie object
     */
    public Movie() {
        System.out.println("Creating Movie");
    }

    /**
     * Gets the id of the movie
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * sets the id of the movie
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the title of the movie
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the movie
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the year the movie was released
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the year the movie was released
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * Gets the MPAA rating of the movie
     * @return the mpaa_rating
     */
    public String getMpaa_rating() {
        return mpaa_rating;
    }

    /**
     * Sets the MPAA rating of the movie
     * @param mpaa_rating the mpaa_rating to set
     */
    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    /**
     * Gets the runtime of the movie
     * @return the runtime
     */
    public Integer getRuntime() {
        return runtime;
    }

    /**
     * Sets the runtime of the movie
     * @param runtime the runtime to set
     */
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
    
    /**
     * Gets the critic's rating
     * @return the critics_consensus
     */
    public String getCritics_consensus() {
        return critics_consensus;
    }

    /**
     * Sets the critic's rating
     * @param critics_consensus the critics_consensus to set
     */
    public void setCritics_consensus(String critics_consensus) {
        this.critics_consensus = critics_consensus;
    }

    /**
     * Gets the release dates of the movie
     * @return the release dates
     */
    public ReleaseDates getRelease_dates() {
        return release_dates;
    }

    /**
     * Sets the release dates
     * @param release_dates the release dates to be set
     */
    public void setRelease_dates(ReleaseDates release_dates) {
        this.release_dates = release_dates;
    }
    
    /**
     * gets the ratings of the movie
     * @return the ratings
     */
    public Ratings getRatings() {
        System.out.println("I'VE BEEN FOUND, RATING ----" + ratings);
        return ratings;
    }

    /**
     * sets the ratings of the movie
     * @param ratings the ratings to set
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }
    
    /**
     * Getter for the synopsis 
     * @return the synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Setter for the synopsis
     * @param synopsis the synopsis to set
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Getter for the poster
     * @return the posters
     */
    public Posters getPosters() {
        return posters;
    }

    /**
     * Setter for the poster
     * @param posters the posters to set
     */
    public void setPosters(Posters posters) {
        this.posters = posters;
    }
    
    /**
     * Getter for the cast
     * @return the abridged_cast
     */
    public ArrayList<Actor> getAbridged_cast() {
        return abridged_cast;
    }

    /**
     * Setter for the cast
     * @param abridged_cast the abridged_cast to set
     */
    public void setAbridged_cast(ArrayList<Actor> abridged_cast) {
        this.abridged_cast = abridged_cast;
    }
    
    /**
     * Getter for the alternate ids
     * @return the alternate_ids
     */
    public AltIds getAlternate_ids() {
        return alternate_ids;
    }

    /**
     * Setter for the alternate ids
     * @param alternate_ids the alternate_ids to set
     */
    public void setAlternate_ids(AltIds alternate_ids) {
        this.alternate_ids = alternate_ids;
    }
    
    /**
     * Getter for the links
     * @return the links
     */
    public MovieLinks getLinks() {
        return links;
    }

    /**
     * Setter for the links
     * @param links the links to set
     */
    public void setLinks(MovieLinks links) {
        this.links = links;
    }
    
    /**
     * Gets the High-Res Poster Image
     * @return link to high-res poster URL
     */
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
            setAvgRating(((avgRating * (userRatings - 1)) + newRating) / userRatings);
            userCheck.put(username, newRating);
        } else {
            double newRating = Double.parseDouble(rating);
            setAvgRating(((avgRating * userRatings) - oldRating + newRating) / userRatings);
            userCheck.put(username, newRating);
        }
    }
    
    /**
     * getter for the average rating of the movie
     * @return Average Rating of the movie
     */
    public Double getAvgRating() {
        return avgRating;
    }
    
    /**
     * Getter for user ratings
     * @return the user ratings
     */
    public int getUserRatings() {
        return userRatings;
    }
    
    /**
     * getter for the average rating of the movie
     * @return Average Rating of the movie
     */
    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    /**
     * Getter for the number of ratings a movie has
     * @return 
     */
    public void setUserRatings(int userRatings) {
        this.userRatings = userRatings;
    }
    
    /**
     * Compares one movie to another
     * @param o the other movie to compare to this movie
     * @return the comparison integer
     */
    @Override
    public int compareTo(Object o) {
        Movie other = (Movie) o;
        return (int) (this.avgRating - other.getAvgRating());
    }
}
