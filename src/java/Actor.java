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
import java.util.List;

@Generated("org.jsonschema2pojo")
class Actor {
    
    @Expose
    private String name;
    @Expose
    private String id;
    @Expose
    private List<String> characters;
    
}
