import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import java.io.Reader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name = "rtservice")
@ApplicationScoped

public class RTRESTService implements Serializable {

    private final String API_KEY = "yedukp76ffytfuy24zsqk7f5";
    
    private List<Movie> dvdMovies = new ArrayList<Movie>();
    private String dvdData;
    
    private List<Movie> theaterMovies = new ArrayList<Movie>();
    private String theaterData;

    
    @PostConstruct
    protected void init() {
        
        dvdData = rottenRestNewDVDs();
        theaterData = rottenRestOpenings();
        buildDvdMovies();
        buildTheaterMovies();
        
    }
    

    /***********************************************
     * Private API starts here                      *
     ***********************************************/

    /**
     * The network functionality. Performs get requests on the provided endpoint
     * and returns the response as a string
     *
     * @param endpoint The validated endpoint
     * @return JSON encoded response
     * @throws Exception Gets thrown to next layer
     */
    private String httpGet(String endpoint) throws Exception {
        URL url = new URL(endpoint);
        String data = "";

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
                        data+=output;
		}
                System.out.println("Got JSON: " + data);
		conn.disconnect();
                } catch (MalformedURLException ex) {
                   Logger.getLogger(RTRESTService.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("Cannot open url");
                }
        return data;
    }

    /**
     * Converts from a given string to JSON encoded object
     *
     * @param str The string to convert to JSON
     * @return JSON endcoded object of the given string
     */
    private JSONObject StringToJson(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            throw new Error(e);
        }
    }

    /**
     * From a string endpoint to a JSON encoded object.
     * Now with exception handling
     *
     * @param endpoint Validated string containing endpoint for server request
     * @return JSON Encoded response from the given endpoint
     */
    private String rottenRestCall(String endpoint) {
        try {
            return httpGet(endpoint);
        } catch(Exception e) {
            throw new Error(e);
        }
    }

    /***********************************************
     * Public API starts here                      *
     ***********************************************/

    /**
     * Takes a user's query and searches Rotten Tomatoes for matches
     *
     * @param query The user's search term
     * @return Matched results from rotten tomatoes
     */
<<<<<<< HEAD
    public String rottenRestSearch(String search) {
        
        String endpoint = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=" +
                API_KEY + "&q=" + search;
=======
    public String rottenRestSearch(String query) {
        String[] words = query.split(" ");
        StringBuilder sentence = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; ++i) {
            sentence.append("%20");
            sentence.append(words[i]);
        }
        String endpoint = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=" +
                API_KEY + "&q=" + sentence.toString();
>>>>>>> origin/master

        return rottenRestCall(endpoint);
    }

    /**
     * Gives the first page of opening movies from Rotten Tomatoes
     *
     * @return First page of opening movies from Rotten Tomatoes
     */
    public String rottenRestOpenings() {
        String endpoint = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/" +
                "opening.json?apikey=" + API_KEY;

        return rottenRestCall(endpoint);
    }

    /**
     * Gives the first page of newly released DVDs from Rotten Tomatoes
     *
     * @return First page of newly released DVDs from Rotten Tomatoes
     */
    public String rottenRestNewDVDs() {
        String endpoint = "http://api.rottentomatoes.com/api/public/v1.0/lists/dvds/" +
                "new_releases.json?apikey=" + API_KEY;

        return rottenRestCall(endpoint);
    }
    
    public void buildDvdMovies() {
        Gson gson = new Gson();
        RTResponse response = gson.fromJson(dvdData, RTResponse.class);
        List<Movie> movies = response.getMovies();
        for (Movie m : movies) {
            getDvdMovies().add(m);
        }   
    }
    
    public void buildTheaterMovies() {
        Gson gson = new Gson();
        RTResponse response = gson.fromJson(theaterData, RTResponse.class);
        List<Movie> movies = response.getMovies();
        for (Movie m : movies) {
            System.out.print(m);
            getTheaterMovies().add(m);
        }    
    }
    
    public ArrayList<Movie> generateSearch(String queryData) {
        Gson gson = new Gson();
        RTResponse response = gson.fromJson(queryData, RTResponse.class);
        ArrayList<Movie> movies = response.getMovies();
        return movies;
    }
    
    public ArrayList<Movie> search(String search) {
        String queryData = rottenRestSearch(search);
        return generateSearch(queryData);
    }
    
    

    /**
     * @return the dvdMovies
     */
    public List<Movie> getDvdMovies() {
        return dvdMovies;
    }
    
    

    /**
     * @return the theaterMovies
     */
    public List<Movie> getTheaterMovies() {
        return theaterMovies;
    }

}
