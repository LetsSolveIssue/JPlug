package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.ConfigDao;
import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.jplug.util.ProgramCompiler;
import com.swinfosoft.jplug.util.ProgramRunner;
import com.swinfosoft.mvc.web.*;

import java.io.*;
import java.util.*;

import javax.servlet.ServletResponse;

public class RunAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//
	
	logger.info("Below user code ");
	ArrayList list=new ArrayList();
	//reading db configuration
	
	int folderId=Integer.parseInt((ActionContext.getParameter("id")));
	String args=ActionContext.getParameter("args").trim();
	String rtv=ActionContext.getParameter("rtv").trim();
	logger.info("At RunAction page id came : "+folderId);
	logger.info("At RunAction page args came :"+args);
	logger.info("At RunAction page rtv came  :"+rtv);
	FolderDao dao=new FolderDao();
	Folder f=dao.getById(folderId);
	File ff=new File(f.getPath());;
	
	String result=ProgramRunner.run(ff, args, rtv);
	logger.info("Contents in result is  : "+result);
	ServletResponse response=ActionContext.getServletResponse();
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println(result);
	out.close();
	logger.info("sucessfully  run ");
	return null;
	}

}
