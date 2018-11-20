package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class UserFormAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("UserFormAction invoked.");
		
		
		return "userForm";
	}

}
