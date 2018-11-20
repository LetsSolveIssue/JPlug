package com.swinfosoft.jplug.actions;


import com.swinfosoft.mvc.web.*;

public class LogoutAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	ActionContext.closeSession();	
	return "loggedOut";
	}

}
