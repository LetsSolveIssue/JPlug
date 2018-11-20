package com.swinfosoft.jplug.actions;
import java.io.File;
import java.sql.*;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class RenFolderAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
		Connection con=null;
	Logger logger=Logger.getRootLogger();	
	Folder folder=new Folder();
	FolderDao dao=new FolderDao();
	String reName=ActionContext.getParameter("name");
	String i=ActionContext.getParameter("id");
	logger.info("folder name isnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn   "+reName);
	logger.info("folder id isssssssssssssssssssssssssssssssssssssssssssssssssssssssss  "+i);
	
	//rename the system folder
	
		folder=dao.getById(Integer.parseInt(i));
		
		String pwfn=(folder.getPath().substring(0,folder.getPath().lastIndexOf("\\")));
		logger.info("database cutted path   ///////////////////////////////////: "+pwfn);
		File f=new File(folder.getPath());
		String name=f.toString();
		logger.info("file oldpath in the system : "+name);
		File nf=new File(pwfn+File.separator+reName);
		logger.info("new path of the folder : "+nf);
	if(f.exists()){
		if(f.renameTo(nf)){
		logger.info("your folder renaming .................................................");
		//logger.info(folder.getParent()+"  This is my path hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		
		
				// Method to Rename folder path and parent path
				renFolderPath(nf.toString(),name,name);
		
				//	Folderdao Mathod to set Folder Name & Folder Path
		
				dao.renameFolder(nf.toString(),reName,Integer.parseInt(i));
		
		ActionContext.setAttribute("newPathofRenameFolder", nf);
		}
	}		
	/*else{
		
		logger.info("sorry folder not found ");
		dao.renameFolder(nf.toString(),Integer.parseInt(i));
	}*/
		
			
	ActionContext.setAttribute("message","Successfully Renamed your folder ");
	
	return "sucessfullyrenamed";
	}
	public void renFolderPath(String s,String path,String p) throws Exception
	{
		Logger log=Logger.getRootLogger();
		Logger.getRootLogger().info("I am in renFolderPath at top");
		Logger.getRootLogger().info("s  : "+s);
		Logger.getRootLogger().info("path pppppppppppp"+path);
		Logger.getRootLogger().info("s 2 times "+p);
		File f=new File(s);
		FolderDao dao=new FolderDao();
		String contents[]=f.list();
		for(int i=0;i<contents.length;i++){
			log.info("folders within "+path+"  is  "+contents[i]);
		}
		String cpath;
		for(int i=0;i<contents.length;i++)
		{
			File child=new File(f,contents[i]);
			if(child.isDirectory())
			{	
			cpath=child.getPath();
			p=p+File.separator+child.getName();
			String parent=child.getParent();
			Logger.getRootLogger().info("Child path"+cpath+"\t\t"+"path1"+p);
			
			dao.renameSubFolder(cpath,parent,p);
			//recursively call to change path of subfolder
			renFolderPath(cpath,path,p);	
			p=path;
			}
		}
		Logger.getRootLogger().info("I am in renFolderPath at bottom");
	}
}
