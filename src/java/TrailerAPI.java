
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Full TrailerAPI functionality is a to do.
 */

/**
 *
 * @author Timothy
 */
public class TrailerAPI implements APIService {
    
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
    
    @Override
    public ArrayList<Item> search(String search) {
        return null;        
    }
    
    @Override
    public ArrayList<Item> getNewReleases() {
        return null;
    }
    
    @Override
    public ArrayList<Item> getNewOpenings() {
        return null;
    }
    
    public String getFeaturedTrailer() {
        String url = "http://api.traileraddict.com/?featured=yes";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(url);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            
        }
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        Node trailer = nodeList.item(0);
        Element eTrailer = (Element) trailer;
        //eTrailer.getElementsByTagName("embed").item(0).getChildNodes().item(0).getChildNodes().item(0).getData();
        return "";
        

    }
}
