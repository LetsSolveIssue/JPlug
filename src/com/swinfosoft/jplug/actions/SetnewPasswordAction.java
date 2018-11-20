package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class SetnewPasswordAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	String rp=null;	
	String mailid=ActionContext.getParameter("mailid");
	String pass=ActionContext.getParameter("pass");
	String repass=ActionContext.getParameter("repass");
	logger.info(pass+"correct ans is :"+repass);
	logger.info("user ans is :"+mailid);
	UserDao udao=new UserDao();
	
	if(pass.equals(repass))
	{
		udao.resetPassword(pass, mailid);
		ActionContext.setAttribute("message", "your password hasbeen updated , you can login now  ");
		 rp ="validpass";
	}
	else{
		ActionContext.setAttribute("message", " sorry !  your password is not correct ");
		 rp ="invalidpass";
	}
	return rp;
	
	}

}
