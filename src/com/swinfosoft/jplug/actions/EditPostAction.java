package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;
import com.swinfosoft.jplug.dao.PostMasterDao;
import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.entity.PostMaster;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class EditPostAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read folder id...
	int id=Integer.parseInt(
			ActionContext.getParameter("postid"));
	PostMasterDao dao=new PostMasterDao();
	PostMaster postm=dao.getById(id);
	logger.info("code=:"+postm.getCode());
	logger.info("title=:"+postm.getTitle());
	ActionContext.setAttribute("posts",postm);
	return "editPost";
	}
	

}
