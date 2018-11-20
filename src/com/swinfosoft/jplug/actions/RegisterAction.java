package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class RegisterAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext
	User user=new User();
	user.setName(ActionContext.getParameter("name"));
	user.setMailId(ActionContext.getParameter("mailId"));
	user.setPassword(ActionContext.getParameter("password"));
	user.setSecurityQuestion(ActionContext.getParameter("squestion"));
	user.setSecurityAnswer(ActionContext.getParameter("ans"));
	user.setRole(User.visitor);
	UserDao dao=new UserDao();
	dao.save(user);
	logger.info("user saved in the db.");
	//save the result of processing in ActionContext
	ActionContext.setAttribute("message","You are successfully registered , Login and Enjoy");
	return "registered";
	}

}
