/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Stores all of the links of a movie
 * @author joesadler
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")

public class Links implements Serializable {
    
    @Expose
    private String self;
    @Expose
    private String next;
    @Expose
    private String alternate;

    /**
     * Getter for the self link
     * @return the self
     */
    public String getSelf() {
        return self;
    }

    /**
     * Setter for the self link
     * @param self the self to set
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * Getter for the next link
     * @return the next
     */
    public String getNext() {
        return next;
    }

    /**
     * Setter for the next link
     * @param next the next to set
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * Getter for the alternate link
     * @return the alternate
     */
    public String getAlternate() {
        return alternate;
    }

    /**
     * Setter for the alternate link
     * @param alternate the alternate to set
     */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }
}
