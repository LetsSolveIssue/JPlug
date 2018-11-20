package com.swinfosoft.jplug.actions;

import java.util.*;
import java.util.Calendar;

import org.apache.log4j.Logger;
import com.swinfosoft.jplug.dao.PostMasterDao;
import com.swinfosoft.jplug.entity.PostMaster;
import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class NewPostAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	User user=(User)	
	ActionContext.getAttribute("user", 
			ActionContext.SessionScope);
	//load  user info in action context...
	ActionContext.setAttribute("username",user.getName());
	return "newPostForm";
	}

}
