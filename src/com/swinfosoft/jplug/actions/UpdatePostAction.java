package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;
import com.swinfosoft.jplug.dao.PostMasterDao;
import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.entity.PostMaster;
import com.swinfosoft.mvc.web.*;
import com.swinfosoft.mvc.web.ActionContext;

public class UpdatePostAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read post id...
	int id=Integer.parseInt(
			ActionContext.getParameter("postid"));
	String title=(String)ActionContext.getParameter("title");
	String contents=(String)ActionContext.getParameter("contents");
	String code=(String)ActionContext.getParameter("code");
	logger.info("title:"+title);
	logger.info("contn:"+contents);
	logger.info("code:"+code);
	PostMasterDao dao=new PostMasterDao();
	PostMaster postm=new PostMaster();
	postm.setTitle(title);
	postm.setContent(contents);
	postm.setCode(code);
	postm.setId(id);
	dao.updatePost(postm);
	ActionContext.setAttribute("message","your post update successfully.....");
	return "updatePost";
	}
	

}
