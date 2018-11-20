package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class LoadProfileAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	User user=(User)	
			ActionContext.getAttribute("user", 
					ActionContext.SessionScope);
	UserDao dao=new UserDao();
	//logger.info("Login user id is : "+user.getId());
	User userinfo=dao.getById(user.getId());
	if(user !=null){
		/*logger.info("This user records got in the database");
		logger.info("userinfo.getMailId() :"+userinfo.getMailId());
		logger.info("userinfo.getName()   :"+userinfo.getName());
		logger.info("+userinfo.getName()  :"+userinfo.getId());
		logger.info("userinfo.getPassword():"+userinfo.getPassword());*/
	
		ActionContext.setAttribute("userinfo",userinfo);
		ActionContext.setAttribute("message", "Hello this user records has been fetched from the database");
		
	}
	
	return "loadProfile";
	
	}

}
