package com.swinfosoft.jplug.actions;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.AbstractDao;
import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class CreateFolderAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	User user=(User)	
	ActionContext.getAttribute("user", 
			ActionContext.SessionScope);
	//read folder details and store them into a Folder object...
	Folder folder=new Folder();
	folder.setUserId(user.getId());
	
	folder.setName(
			ActionContext.getParameter("name"));
	String sub=ActionContext.getParameter("option");
	logger.info("value of option is: "+sub);
	String path;
	if(sub !=null)
	{
		folder.setParent(
				ActionContext.getParameter("parent"));
		path=folder.getParent()+File.separator+folder.getName();
		
	}
	else
	{
		folder.setParent(null);
		path=CreateFolderAction.class.getResource("/").getPath();
		logger.info("selected path is: "+path);
		/*int index=path.indexOf("classes");
		path=path.substring(index+8);*/
		logger.info("parent path: "+path);
		path=path+File.separator+folder.getName();
		logger.info("folder path: "+path);
		
	}
	//create the folder in the file system...
	File f=new File(path);
	String pp=f.getPath();
	logger.info("creating folder at path: "+path);
	if(f.mkdir())
	{
		logger.info("folder crated, saving its details...");
		folder.setPath(pp);
		FolderDao dao=new FolderDao();
		dao.save(folder);
		logger.info("folder details saved.");
		ActionContext.setAttribute("message", "folder created.");
	}
	else
	ActionContext.setAttribute("message", "folder not created.");
	
	return "createFolderResult";
	}

}
