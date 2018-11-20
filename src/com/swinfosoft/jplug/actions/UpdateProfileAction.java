package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class UpdateProfileAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext
	User user=(User)ActionContext.getAttribute("user", 
			ActionContext.SessionScope);
	user.setName(ActionContext.getParameter("name"));
	user.setMailId(
			ActionContext.getParameter("mailId"));
	user.setPassword(
			ActionContext.getParameter("password"));
	
	UserDao dao=new UserDao();
	dao.update(user);
	logger.info("user updated in the db.");
	//save the result of processing in ActionContext
	ActionContext.setAttribute("message","Your profile successfully updated.");
	return "updated";
	}

}
