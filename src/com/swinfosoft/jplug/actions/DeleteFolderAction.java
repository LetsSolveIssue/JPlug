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

public class DeleteFolderAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read folder id...
	int id=Integer.parseInt(
			ActionContext.getParameter("id"));
	FolderDao dao=new FolderDao();
	Folder folder=dao.getById(id);
	//Remove folder form the file system...
	File f=new File(folder.getPath());
	
	System.out.println("Folder name"+f.getName());
	
	if(f.delete())
	{
		logger.info("folder deleted from the file system.");
		//remove folder details from the db..
		dao.delete(folder.getId());
		logger.info("folder details removed from db...");
		ActionContext.setAttribute("message", "folder successfully deleted.");
		return "folderDeleted";
	}
	else
	{
		ActionContext.setAttribute("message", 
				"Folder isn't empty, want to delete all its contents");
		ActionContext.setAttribute("folder", folder);
	return "folderNotDeleted";
	}
	}
	

}
