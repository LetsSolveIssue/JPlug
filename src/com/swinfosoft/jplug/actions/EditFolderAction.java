package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class EditFolderAction implements Action {

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
	ActionContext.setAttribute("folder", folder);
	//logger.info(folder.getSize());
	return "renameFolder";
	}
	

}
