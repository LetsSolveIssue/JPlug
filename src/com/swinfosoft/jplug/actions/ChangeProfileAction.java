package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ChangeProfileAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	User user=new User();
	user.setName(
			ActionContext.getParameter("name"));
	user.setMailId(
			ActionContext.getParameter("email"));
	user.setPassword(
			ActionContext.getParameter("password"));
	user.setSecurityQuestion(
			ActionContext.getParameter("squestion"));
	user.setSecurityAnswer(
			ActionContext.getParameter("ans"));
	user.setRole(
			Integer.parseInt(ActionContext.getParameter("role")));
	user.setId(
			Integer.parseInt(ActionContext.getParameter("uid")));
	logger.info("ActionContext.getParameter(name)"+ActionContext.getParameter("name"));
	logger.info("ActionContext.getParameter(email)"+ActionContext.getParameter("email"));
	logger.info("ActionContext.getParameter(password)"+ActionContext.getParameter("password"));
	logger.info("ActionContext.getParameter(role)"+ActionContext.getParameter("role"));
	logger.info("ActionContext.getParameter(squestion)"+ActionContext.getParameter("squestion"));
	logger.info("ActionContext.getParameter(ans)"+ActionContext.getParameter("ans"));
	logger.info("ActionContext.getParameter(uid)"+ActionContext.getParameter("uid"));
	UserDao dao=new UserDao();
	dao.update(user);
	
	ActionContext.setAttribute("message", "Sucessfully Changed your profile ");
	
	return "profileChanged";
	
	}

}
