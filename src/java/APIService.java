
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Timothy
 */
public interface APIService {
    

    /**
     *  Takes the search information and passes it into the API.
     * 
     *  Passes the queryData into the formating method generateList().
     * 
     * @param search The search information that they want to look for
     * @return list of items
     */
    public ArrayList<Item> search(String search);
    
    /**
     * Returns the newest releases depending on the API.
     * A Movie API will return the newest DVD releases.
     * A Game API will return the newest Game releases.
     * 
     * @return list of items
     */
    public ArrayList<Item> getNewReleases();
    
    /**
     * Returns the newest releases depending on the API.
     * A Movie API will return the newest Theater releases.
     * 
     * @return list of items
     */
    public ArrayList<Item> getNewOpenings();
    
}
