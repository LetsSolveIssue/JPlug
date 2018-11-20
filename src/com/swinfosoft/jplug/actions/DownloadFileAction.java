package com.swinfosoft.jplug.actions;

import com.swinfosoft.mvc.web.Action;

import java.io.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;
public class DownloadFileAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		HttpServletRequest request=(HttpServletRequest)ActionContext.getServletRequest();
		HttpServletResponse response = (HttpServletResponse)ActionContext.getServletResponse();
		//int fid=Integer.parseInt(request.getParameter("fid"));
		String path=ActionContext.getParameter("path");
		logger.info("File Path="+path);
		//FileDao fdao=new FileDao();
		
		File file = new File(path);
		
		String filename=file.getName();
		java.io.File fileDownload=new java.io.File(file.getPath());
		response.setContentType("APPLICATION/OCTET-STREAM"); 
		response.setHeader("Content-Disposition","attachment; filename=\""+ filename +"\""); 		
	  	java.io.FileInputStream in = new java.io.FileInputStream(fileDownload);
	  	OutputStream out=response.getOutputStream(); 
	  	byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
         
        in.close();
        out.close(); 
	  	
		return null;
		
	}

}


//ActionContext.setAttribute("message", "folder has been download sucessfully ");
//return "downloadFile";