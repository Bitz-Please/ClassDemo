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
 *
 * @author tleeo_000
 */
@ManagedBean
@SessionScoped
public class Navigation implements Serializable {
    
    public Navigation () {
        System.out.println("Making Navigation");
    }
    public String loginPage() {
        return "login";
    }
    
    public String indexPage() {
        return "index";
    }
    
    public String registrationPage() {
        return "registration";
    }
    
    public String frontPage() {
        return "front";
    }
    
    public String weatherPage() {
        return "weather";
    }

    public Boolean contextRender(Boolean answer) {
        return answer;
	}
	
    public String userInfoPage() {
        return "userInfo";
    }
}
