package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.ConfigDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ConfigAdminAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	logger.info("ConfigDBAction invoked.");
	
	//reading db configuration
	String name=ActionContext.getParameter("name");
	String password=ActionContext.getParameter("password");
	String mailId=ActionContext.getParameter("mailId");
	String squestion=ActionContext.getParameter("squestion");
	String ans=ActionContext.getParameter("ans");
	User user=new User();
	user.setName(name);
	user.setMailId(mailId);
	user.setPassword(password);
	user.setSecurityQuestion(squestion);
	user.setSecurityAnswer(ans);
	user.setRole(User.admin);
	UserDao dao=new UserDao();
	dao.save(user);	
	
	return "adminConfigured";
	}

}
