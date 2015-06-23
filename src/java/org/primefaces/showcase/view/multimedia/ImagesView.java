package org.primefaces.showcase.view.multimedia;
 
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagesView {
     
    private List<String> images;
     /**
      * Creates an arrayList of "movie1.jpg, movie2.jpg, etc"
      * Used in the contentFlow to know the file names of
      * what to display in the web/images directory.
      */
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            images.add("movie" + i + ".jpg");
        }
    }
 
    /**
     * @return image arrayList
     */
    public List<String> getImages() {
        return images;
    }
}