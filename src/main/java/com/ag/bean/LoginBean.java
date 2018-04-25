package com.ag.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.ag.service.UserService;
import com.ag.model.OICUserLogin;
import com.ag.model.TblInvFrameMetadata;
import com.ag.bean.SessionBean;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable, ApplicationContextAware {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OICUserLogin oicuserLogin;
	private String userId;
	private String autoAuthCode;
	private String new_AuthCode;	
	private String confirm_New_AuthCode;
	private UserService service;	
	public static ApplicationContext ac;
	@PostConstruct
    private void initialize() {			
		service = (UserService) ac.getBean("userService");

		HttpSession session1 = SessionBean.getSession();
		session1.invalidate();		
		oicuserLogin = new OICUserLogin();	
		
    }	
	
	public void doLogin() throws IOException {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
				.getContext();
		String path = servletContext.getRealPath("/");
		OICUserLogin user = service.doLogin(oicuserLogin);			
		if(null != user) {
			HttpSession session = SessionBean.getSession();
	        session.setAttribute("userName", user.getUserName());
	        session.setAttribute("userId", user.getUserId());
	        session.setAttribute("role", user.getRoleName());
	        session.setAttribute("site", user.getSite());
	        session.setAttribute("email", user.getEmail());
			//return "projectList?faces-redirect=true";	        
	       
	        FacesContext.getCurrentInstance().getExternalContext().redirect("uploadFrames.xhtml");      
	        
		}		
		else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"", 
							"Username or Password is Wrong"));
			}
	}	OICUserLogin user;	
	
	
	
	public String getUserName() {
		new FrameMetadata().clearErrorFramesList();
		HttpSession session = SessionBean.getSession();
        String username = (String) session.getAttribute("userName");
        return username;
	}	
	public String getRole() {
		HttpSession session = SessionBean.getSession();
        String role = (String) session.getAttribute("role");
        return role;
	}	
	public String getSite() {
		HttpSession session = SessionBean.getSession();
        String username = (String) session.getAttribute("site");
        return username;
	}	
	public String logout() {
		new FrameMetadata().setErrorframesList(new ArrayList<TblInvFrameMetadata>());
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login?faces-redirect=true";
    }	
	public void check(ComponentSystemEvent event) {
	    if (getUserName() == null || getUserName().equals("") || getUserName().equalsIgnoreCase("null")) {
	        try {
				FacesContext.getCurrentInstance().getExternalContext()
				.redirect("login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
	
	public String getNew_AuthCode() {
		return new_AuthCode;
	}
	public void setNew_AuthCode(String new_AuthCode){
		this.new_AuthCode = new_AuthCode;
	}
	public String getConfirm_New_AuthCode() {
		return confirm_New_AuthCode;
	}
	public void setConfirm_New_AuthCode(String confirm_New_AuthCode) {
		this.confirm_New_AuthCode = confirm_New_AuthCode;
	}
	/**
	 * @return the controller
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAutoAuthCode() {
		return autoAuthCode;
	}
	public void setAutoAuthCode(String autoAuthCode) {
		this.autoAuthCode = autoAuthCode;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		ac = applicationContext;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public OICUserLogin getOicuserLogin() {
		return oicuserLogin;
	}

	public void setOicuserLogin(OICUserLogin oicuserLogin) {
		this.oicuserLogin = oicuserLogin;
	}
	
}
