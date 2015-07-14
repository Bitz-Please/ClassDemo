/*
    RottenTomatoes API restCall managing class.

    
*/

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RTRESTService implements Serializable {

    private final String API_KEY = "yedukp76ffytfuy24zsqk7f5";
   
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

    public String rottenRestSearch(String query) {
        String[] words = query.split(" ");
        StringBuilder sentence = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; ++i) {
            sentence.append("%20");
            sentence.append(words[i]);
        }
        String endpoint = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=" +
                API_KEY + "&q=" + sentence.toString();

        System.out.println("We are searching at ------------> )" + endpoint);
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
    
     
    /**
     *  Turns the JSON response information from RottenTomatoes API into 
     *  valid Movie objects. Then gives the ArrayList of movies back to be displayed
     *  to the user who searched.
     * 
     * @param data The raw JSON data from RottenTomatoes API
     * @return 
     */
    private ArrayList<Movie> generateList(String data) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Integer.class,
                    new IntegerTypeAdapter()).create();
        System.out.println("FINAL TEST ---------------------->" + data);
        RTResponse response = gson.fromJson(data, RTResponse.class);
        ArrayList<Movie> movies = response.getMovies();
        return movies;
    }
    
    /**
     *  Takes the search information and passes it into the rottenSearch.
     * 
     *  Passes the queryData into the formating method generateSearch().
     * 
     * @param search The search information that they want to look for
     * @return 
     */
    public ArrayList<Movie> search(String search) {
        String queryData = rottenRestSearch(search);
        System.out.println("Query Data ------------->" + queryData);
        return generateList(queryData);
    }
    
    public ArrayList<Movie> getTheaterMovies() {
        String theaterData = rottenRestOpenings();
        System.out.println("Theater Data ------------->" + theaterData);
        return generateList(theaterData);
    }
    
    public ArrayList<Movie> getDvdMovies() {
        String dvdData = rottenRestNewDVDs();
        System.out.println("Dvd Data ------------->" + dvdData);
        return generateList(dvdData);
    }
    
}