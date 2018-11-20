package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ForgetPasswordAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	String mailid=ActionContext.getParameter("emailid");
	UserDao dao=new UserDao();
	User user=dao.findMailId(mailid);
	if(user!=null)
	{
		
		ActionContext.setAttribute("userques", user);
		logger.info("user is not null ok babab");
	}
	logger.info("this is question : "+user.getSecurityQuestion());
	logger.info("this is question : "+user.getSecurityAnswer());
	ActionContext.setAttribute("message", "To Reset , Write the Answer ?  ");
	return "forgetPassword";
	}

}
