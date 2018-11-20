package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class LoginAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	User user=new User();
	user.setMailId(
			ActionContext.getParameter("userId"));
	user.setPassword(
			ActionContext.getParameter("password"));
	UserDao dao=new UserDao();
	logger.info("ActionContext.getParameter(userId) "+ActionContext.getParameter("userId"));
	logger.info("ActionContext.getParameter(password) "+ActionContext.getParameter("password"));
	if(dao.findUser(user))
	{
	ActionContext.setAttribute("user", 
			user,ActionContext.SessionScope);
	return "validUser";
	}
	else
		return "invalidUser";
	
	
	
	}

}
