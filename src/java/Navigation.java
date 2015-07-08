/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *Manages the navigation of the page
 * @author tleeo_000
 */
@ManagedBean
@SessionScoped
public class Navigation implements Serializable {

    /**
     * creates the navigation object
     */    
    public Navigation () {
        System.out.println("Making Navigation");
    }
    
    /**
     * Directs xhtml code to login page 
     * @return login
     */
    public String loginPage() {
        return "login";
    }
    
     /**
     * Directs xhtml code to index page 
     * @return index
     */
    public String indexPage() {
        return "index";
    }
    
     /**
     * Directs xhtml code to registration page 
     * @return registration
     */
    public String registrationPage() {
        return "registration";
    }

    /**
     * The contextRender
     * @param answer the answer
     * @return the answer passed into the contextRender
     */
    public Boolean contextRender(Boolean answer) {
        return answer;
	}
    /**
     * Directs xhtml code to userInfo page 
     * @return userInfo
     */
    public String userInfoPage() {
        return "userInfo";
    }
}
