package com.swinfosoft.jplug.actions;
import java.util.*;
import org.apache.log4j.Logger;
import com.swinfosoft.jplug.dao.PostMasterDao;
import com.swinfosoft.jplug.entity.PostMaster;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class ShowReplyAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	int postId=Integer.parseInt(
			ActionContext.getParameter("postId"));
	PostMasterDao dao=new PostMasterDao();
	// load the post by postid from postmaster...
	PostMaster post=dao.getById(postId);
	// load the post by postid from postanswere...
	List<PostMaster> list=dao.showReply(postId);
	ActionContext.setAttribute("post",post);
	ActionContext.setAttribute("postm",list);
	return "showReply";
	}
	

}
