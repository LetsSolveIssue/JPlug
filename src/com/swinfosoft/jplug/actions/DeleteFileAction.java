package com.swinfosoft.jplug.actions;

import java.io.File;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class DeleteFileAction implements Action {

	@Override
	public String processRequest() throws Exception {
		
		Logger logger=Logger.getRootLogger();	
		//read folder id...
		
		String path=
				ActionContext.getParameter("path");
		
		//Remove folder form the file system...
		File f=new File(path);
		System.out.println(f.getPath());
		
		System.out.println("Folder name"+f.getName());
	
		f.delete();
		//ViewProgramAction l=new ViewProgramAction();
	//	l.processRequest();
		//return null;
		ActionContext.setAttribute("message", "sucessfully deleted your selected file");
		return "deleteFile";
	}

}