
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robertwaters
 */
@ManagedBean (name = "service")
@ApplicationScoped
public class WeatherRESTService {

    private List<Weather> wxdata = new ArrayList<Weather>();
    private String data;
    

    @PostConstruct
    protected void init() {

                URL url = null;
        try {
                url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=0491a31ce6efd3fac346f3cdc7e27b46");
        
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
                data = "";
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
                        data+=output;
		}
                System.out.println("Got JSON: " + data);
		conn.disconnect();
                } catch (MalformedURLException ex) {
                   Logger.getLogger(WeatherRESTService.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("Cannot open url");
                }
        }

    
    public List<Weather> getWxdata() {
        System.out.println("Getting the REST data");
        Gson gson = new Gson();
        WeatherResponse response = gson.fromJson(data, WeatherResponse.class);
        System.out.println("resp: " + response);  
        System.out.println("Got city response: " + response.getBase());
        List<Weather> forecasts = response.getWeather();
        System.out.println("Found " + forecasts.size() + " forecasts");
        for (Weather f : forecasts) {
            wxdata.add(f);
        }
        
        System.out.println("Returning the temp data");
        return wxdata;
        
        
    }
}
