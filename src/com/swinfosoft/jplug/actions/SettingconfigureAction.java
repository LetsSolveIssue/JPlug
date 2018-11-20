package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.ConfigDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class SettingconfigureAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	logger.info("This is jdk verson Setting page");
	
	return "settingConfigure";
	}

}
