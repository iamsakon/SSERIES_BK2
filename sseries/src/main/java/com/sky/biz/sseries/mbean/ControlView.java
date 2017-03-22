package com.sky.biz.sseries.mbean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "controlView")
@SessionScoped
public class ControlView {

	String currentView = "";
	
	@PostConstruct
	public void init(){
		this.currentView = "app/welcome";
	}
	
	public String getCurrentView() {
		return currentView;
	}

	public void setCurrentView(String currentView) {
		this.currentView = currentView;
	}
	
	public void doNav() {	    
	    String str = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("navto");
	    this.doNav2(str);
	}
	
	public void doNav2(String str){
		if(str!=null && !str.equals(""))
	    	this.currentView = str;
	}
	
	public String getSessionId(){
		FacesContext fCtx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
		String sessionId = session.getId();
		return sessionId;
	}
	
}
