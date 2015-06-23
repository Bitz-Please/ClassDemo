import org.json.JSONException;
import org.json.JSONObject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

@ManagedBean (name = "service")
@ApplicationScoped

public class RTRESTservice {

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
    private static String httpGet(String endpoint) throws Exception {
        URL url = new URL(endpoint);

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);

            String msg = "";

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            for (int c; (c = in.read()) >= 0; msg += (char) c) ;

            return msg.toString();
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /**
     * Converts from a given string to JSON encoded object
     *
     * @param str The string to convert to JSON
     * @return JSON endcoded object of the given string
     */
    private static JSONObject StringToJson(String str) {
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
    private static JSONObject rottenRestCall(String endpoint) {
        try {
            return StringToJson(httpGet(endpoint));
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
    public JSONObject rottenRestSearch(String query) {
        
        String endpoint = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=" +
                API_KEY + "&q=" + query;

        return rottenRestCall(endpoint);
    }

    /**
     * Gives the first page of opening movies from Rotten Tomatoes
     *
     * @return First page of opening movies from Rotten Tomatoes
     */
    public JSONObject rottenRestOpenings() {
        String endpoint = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/" +
                "opening.json?apikey=" + API_KEY;

        return rottenRestCall(endpoint);
    }

    /**
     * Gives the first page of newly released DVDs from Rotten Tomatoes
     *
     * @return First page of newly released DVDs from Rotten Tomatoes
     */
    public JSONObject rottenRestNewDVDs() {
        String endpoint = "http://api.rottentomatoes.com/api/public/v1.0/lists/dvds/" +
                "new_releases.json?apikey=" + API_KEY;

        return rottenRestCall(endpoint);
    }

}
