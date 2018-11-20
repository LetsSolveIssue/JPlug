package com.swinfosoft.jplug.actions;

import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class AddJarAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		//fetch user from the session
		User user=(User)ActionContext.getAttribute("user",
				ActionContext.SessionScope);
		logger.info("loading folders of the user...");
		FolderDao dao=new FolderDao();
		List<Folder> list=dao.allFolders(user.getId());
		if(!list.isEmpty())
			ActionContext.setAttribute("folders", list);
		return "addJar";
	}

}
