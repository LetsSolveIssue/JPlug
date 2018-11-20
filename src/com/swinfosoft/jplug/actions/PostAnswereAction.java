package com.swinfosoft.jplug.actions;

import java.util.*;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.PostMasterDao;
import com.swinfosoft.jplug.entity.PostMaster;
import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class PostAnswereAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	int id=Integer.parseInt(
			ActionContext.getParameter("postid"));
	PostMasterDao dao=new PostMasterDao();
	PostMaster postm=dao.getById(id);
	ActionContext.setAttribute("posts",postm);
	//load  user info in action context...
	return "postAnswereForm";
	}

}
