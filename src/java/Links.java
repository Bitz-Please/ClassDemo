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
     * @return the self
     */
    public String getSelf() {
        return self;
    }

    /**
     * @param self the self to set
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * @return the next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * @return the alternate
     */
    public String getAlternate() {
        return alternate;
    }

    /**
     * @param alternate the alternate to set
     */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }
}
