
import java.io.Serializable;

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
class AltIds implements Serializable {
    @Expose
    private String imbd;

    /**
     * @return the imbd
     */
    public String getImbd() {
        return imbd;
    }

    /**
     * @param imbd the imbd to set
     */
    public void setImbd(String imbd) {
        this.imbd = imbd;
    }
}
