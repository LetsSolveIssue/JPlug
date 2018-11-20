package com.swinfosoft.jplug.actions;

import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class CreateProgramAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
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
				log.info("yes mere andar data hai    ..........................................");
				}
		
		return "createProgram";
	}

}
