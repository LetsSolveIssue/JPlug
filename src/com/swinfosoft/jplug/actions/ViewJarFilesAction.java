package com.swinfosoft.jplug.actions;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ViewJarFilesAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
		Connection con=null;
	Logger logger=Logger.getRootLogger();	
	Folder folder=new Folder();
	FolderDao dao=new FolderDao();
	String s=ActionContext.getParameter("jarFolder");
	logger.info("folder name isnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn   "+s);
	// Logic to show jar files in the selected folder
	File file=new File(s);
	File files[]=file.listFiles();
	
	//ArrayList filelist=new ArrayList();
	int k=0,total_no_of_javafile=0;
	
	if(files!=null)
	{
		for(int i=0;i<files.length;i++){
		logger.info("This is file name "+files[i].getName());
		logger.info("This is file name "+files[i].getName().substring(files[i].getName().lastIndexOf(".")));
		if(files[i].getName().substring(files[i].getName().lastIndexOf(".")).equals(".jar"))
		{
			logger.info("I am java file :"+files[i].getName());
			//filelist.add(files[i].getName());
			//javafiles[k++]=files[i];
			total_no_of_javafile++;
		}
		}
	}
	logger.info("total_no_of_javafile   :  "+total_no_of_javafile);
	File javafiles[]=new File[total_no_of_javafile];
	if(files!=null)
	{
		for(int i=0;i<files.length;i++){
		logger.info("This is file name "+files[i].getName());
		logger.info("This is file name "+files[i].getName().substring(files[i].getName().lastIndexOf(".")));
		if(files[i].getName().substring(files[i].getName().lastIndexOf(".")).equals(".jar"))
		{
			logger.info("I am java file :"+files[i].getName());
			//filelist.add(files[i].getName());
			javafiles[k++]=files[i];
		}
		}
	}
	logger.info("length of javafile array is "+javafiles.length);
	ActionContext.setAttribute("files",javafiles);		
	ActionContext.setAttribute("message","Successfully get your jar files ");
	return "viewJarFiles";
	}

}

/*package com.swinfosoft.jplug.actions;
import java.io.File;
import java.sql.*;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ViewJarFilesAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
		Connection con=null;
	Logger logger=Logger.getRootLogger();	
	Folder folder=new Folder();
	FolderDao dao=new FolderDao();
	String s=ActionContext.getParameter("jarFolder");
	logger.info("folder name isnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn   "+s);
	
	
	// Logic to show jar files in the selected folder
	File file=new File(s);
	File files[]=file.listFiles();
	ActionContext.setAttribute("files",files);
	for(int i=0;i<files.length;i++){
		String jarfile=files[i].getName();
		String ext=jarfile.substring(jarfile.indexOf("."));
		logger.info("ext : "+ext);
		if(files[i].isFile() && ext.equals(".jar")){
			ActionContext.setAttribute("files",files);
			logger.info("===========================================================================================================");
			logger.info("I am jar file in the selected folder "+files[i].getName()+"\t"+files[i].getPath()+"\t"+files[i].getParent());
			logger.info("===========================================================================================================");
		}
	}
	
			
	ActionContext.setAttribute("message","Successfully get your jar files ,This time show on the console....");
	
	return "viewJarFiles";
	}

}
*/