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

public class SubFolderDeleteAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	System.out.println("hi i am going to delete a folder");
	Logger logger=Logger.getRootLogger();	
	//read folder id...
	
	int id=Integer.parseInt(
			ActionContext.getParameter("id"));

	
	FolderDao dao=new FolderDao();
	Folder folder=dao.getById(id);
	//Remove folder form the file system...
	
	File f=new File(folder.getPath());
	String s=f.getPath();
	logger.info("path"+s);
	deleteSubFolder(s);
	ActionContext.setAttribute("message", "folder successfully deleted.");
	return "subFolderDeleted";
	}
	
	
	public void deleteSubFolder(String s) throws Exception
	{
		File f=new File(s);
			if(f.isDirectory())
			{
				String contents[]=f.list();	
			
				for(int i=0;i<contents.length;i++)
				{
					File child=new File(f,contents[i]);
					if(child.isDirectory())
					{
						String a=child.getPath();
						System.out.println("child name= "+child.getName());
						deleteSubFolder(a);
					}
					else
					{
						delete(child);
					}
				}
				delete(f);
			}
			else
			{
				delete(f);
				//delete(f);
			}
	}
	public void delete(File f)throws Exception
	{
		if(f.delete())
		{
			Logger logger=Logger.getRootLogger();	
			logger.info("folder deleted from the file system.");
			//remove folder details from the db..
			FolderDao dao=new FolderDao();
			dao.deleteByName(f.getName());
			
			logger.info("folder details removed from db...");
			//System.out.println("path of deleted folder"+folder.getPath());
			
		}
	}


}
