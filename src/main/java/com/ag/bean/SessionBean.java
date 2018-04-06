package com.ag.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
public class SessionBean {
 
    public static HttpSession getSession() {
    	return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    } 
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
 
    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        
        if (session != null)
            return (String) session.getAttribute("userName");
        else
            return null;
    }
 
    public static String getEmail() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("email");
        else
            return null;
    }
    
    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("userId");
        else
            return null;
    }
    
    public static String getRole() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("role");
        else
            return null;
    }
    
    public static String getSite() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("site");
        else
            return null;
    }    
    public static String getBackFromImageUpload() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);        
        if (session != null)
            return (String) session.getAttribute("backwardValue");
        else
            return null;
    }    
}