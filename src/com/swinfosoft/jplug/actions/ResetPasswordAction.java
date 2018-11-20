package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ResetPasswordAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	String rp=null;	
	String mailid=ActionContext.getParameter("mailid");
	String cans=ActionContext.getParameter("cans");
	String ans=ActionContext.getParameter("ans");
	logger.info("correct ans is :"+cans);
	logger.info("user ans is :"+ans);
	logger.info("user ans is :"+mailid);
	if(cans.equalsIgnoreCase(ans))
	{
		ActionContext.setAttribute("message", "you can reset password  ");
		ActionContext.setAttribute("mailid", mailid);
		 rp ="validans";
	}
	else{
		ActionContext.setAttribute("message", " sorry !  your answer is not correct ");
		 rp ="invalidans";
	}
	return rp;
	
	}

}
