package com.swinfosoft.jplug.actions;
import java.io.File;
import java.util.*;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ViewFolderOfUserAction implements Action {
	
	public String processRequest() throws Exception
	{
		
		Logger logger=Logger.getRootLogger();
		String returnfolderorusers;
		
		int uid=Integer.parseInt(ActionContext.getParameter("selectedUser"));
		logger.info("hello selected user id is : "+uid);
		//if(true){
		
				//load folders of the user...
				FolderDao dao=new FolderDao();
				List<Folder> list=
						dao.allFolders(uid);
				
				if(list.size()>0)
				{
				ActionContext.setAttribute("folders", list);	
				}
				return "viewFolders";
		
		//}
				
	}	
}