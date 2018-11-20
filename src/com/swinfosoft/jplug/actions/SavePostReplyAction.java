package com.swinfosoft.jplug.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.PostMasterDao;
import com.swinfosoft.jplug.entity.PostMaster;
import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class SavePostReplyAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	User user=(User)	
	ActionContext.getAttribute("user", 
			ActionContext.SessionScope);
	String code=null;
	//load folders of the user...
	PostMaster postm=new PostMaster();
	PostMasterDao dao=new PostMasterDao();
	//Calender cal=new Calender();
	DateFormat df=new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");
	Date date=new Date();
	String datetime=df.format(date);
	logger.info("time n date"+datetime);
	postm.setId(Integer.parseInt(ActionContext.getParameter("postId")));
	
	//postm.setId(Integer.parseInt(ActionContext.getParameter("postId")));
	
	dao.likePost(Integer.parseInt(ActionContext.getParameter("postId")));
	postm.setUserName(user.getName());
	logger.info("geting postdata"+ActionContext.getParameter("postdata"));
	//postm.setContent(ActionContext.getParameter("postdata"));
	postm.setTitle((String)ActionContext.getParameter("title"));
	postm.setContent((String)ActionContext.getParameter("contents"));
	code=(String)ActionContext.getParameter("code");
	postm.setCode(code);
	postm.setDate(datetime);
	dao.saveReply(postm);
	ActionContext.setAttribute("username",user.getName());
	ActionContext.setAttribute("message", "Sucessfully posted your Answer....");
	return "savePostReply";
	}
}
