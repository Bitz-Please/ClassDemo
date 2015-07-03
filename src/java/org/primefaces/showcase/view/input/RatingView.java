package org.primefaces.showcase.view.input;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.RateEvent;
/**
 * Class tha manages the view of the ratings of a movie
 * @author megi
 */ 
@ManagedBean
public class RatingView {
     
    private Integer rating1;
    
    /**
     * Updates the UI after a user has rated a movie
     * @param rateEvent the event when the user rates a movie
     */
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    /**
     * Updates the UI after a user cancels their event
     */
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
    /**
     * Gets the rating of the user
     * @return the rating
     */
    public Integer getRating1() {
        return rating1;
    }
 
    /**
     * Sets the rating by the user
     * @param rating1 the rating 
     */
    public void setRating1(Integer rating1) {
        this.rating1 = rating1;
    }
}