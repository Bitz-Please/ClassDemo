/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Holds information about an actor in a particular movie
 * @author joesadler
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.util.List;

@Generated("org.jsonschema2pojo")
class Actor {
    
    @Expose
    private String name;
    @Expose
    private String id;
    @Expose
    private List<String> characters;

    /**
     * Getter for the name of the actor
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name of the actor
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
   
    /**
     * Getter for the id of the actor
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the id of an actor
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for all of the characters an actor has played
     * @return the characters
     */
    public List<String> getCharacters() {
        return characters;
    }

    /**
     * Setter for the characters an actor has played
     * @param characters the characters to set
     */
    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }
    
}
