package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.ConfigDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ConfigDBAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	
	logger.info("Your code is going to be compile................................");
	
	//reading db configuration
	String user=ActionContext.getParameter("name");
	String password=ActionContext.getParameter("password");
	String db=ActionContext.getParameter("db");
	ConfigDao dao=new ConfigDao();
	dao.configure(user,password,db);
		
	return "configured";
	}

}
