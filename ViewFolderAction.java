package com.swinfosoft.jplug.actions;
import java.io.File;
import java.util.*;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ViewFolderAction implements Action {
	
	public String processRequest() throws Exception
	{
		
		Logger logger=Logger.getRootLogger();
		String returnfolderorusers;
		String s=ActionContext.getParameter("f");
		//String u=ActionContext.getParameter("f");
		logger.info("self :  "+s);
		//logger.info("user :  "+u);
		if(s.equals("self")){
		User user=(User)	
				ActionContext.getAttribute("user", 
						ActionContext.SessionScope);
				//load folders of the user...
				FolderDao dao=new FolderDao();
				List<Folder> list=
						dao.allFolders(user.getId());
				
				if(list.size()>0)
				{
				ActionContext.setAttribute("folders", list);	
				}
				return "viewFolders";
		}
		else{
			UserDao dao=new UserDao();
			List <User>user=dao.selectAllUsers();
			/*logger.info("user id is : "+user.getId());
			logger.info("user name is :"+user.getName());*/
			//User u=(User)user;
			logger.info("Hello I am in else block of view Folder");
			ActionContext.setAttribute("users",user);
			//logger.info("this is your id : "+u.getId());
			//logger.info("this is your name : "+u.getName());
			/*ListIterator itr=user.listIterator();
			while(itr.hasNext()){
				User u=((User)itr.next());
				logger.info("Hello tm i am data : "+u.getId());
				logger.info("Hello tm i am data : "+u.getName());
				logger.info("Hello tm i am data : "+u.getPassword());
				
			}*/
			ActionContext.setAttribute("message", "you have following users");
			return "viewUsers";
		}
				
	}	
}