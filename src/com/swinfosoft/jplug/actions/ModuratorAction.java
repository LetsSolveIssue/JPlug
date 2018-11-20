package com.swinfosoft.jplug.actions;

import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class ModuratorAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		//fetch user from the session
		
			ActionContext.setAttribute("message", "Work at processing...");
		return "modurator";
	}

}
