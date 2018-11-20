package com.swinfosoft.jplug.actions;
import java.io.File;
import java.util.*;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ViewProgramFolderAction implements Action {
	
	public String processRequest() throws Exception
	{
		Logger log=Logger.getRootLogger();
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
				return "viewProgramFolders";
		
	}	
	
	

}



