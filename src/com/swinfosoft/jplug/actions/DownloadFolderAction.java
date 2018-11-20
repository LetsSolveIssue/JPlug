package com.swinfosoft.jplug.actions;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class DownloadFolderAction implements Action {
	
	//public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public String processRequest() throws Exception 
	{
		
		Logger logger=Logger.getRootLogger();	
		logger.info("Hello sir");
		HttpServletResponse response=(HttpServletResponse)ActionContext.getServletResponse();
		logger.info("hi sir");
		String folderpath=
				ActionContext.getParameter("path");
		
	
		logger.info("your folder path is : "+folderpath);
		
		try {
			//
			// The path below is the root directory of data to be
			// compressed.
			//
			//String path = getServletContext().getRealPath("data");
			File directory = new File(folderpath);
			String[] files = directory.list();
			if (files != null && files.length > 0) {
				
				byte []zip=zipFiles(directory,files);
				ServletOutputStream sos = response.getOutputStream();
				response.setContentType("APPLICATION/ZIP");
				response.setHeader("Content-Disposition", "attachment; filename="+directory.getName()+".zip");
				sos.write(zip);
				sos.flush();
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "downloadFolder";
		}
		public byte[] zipFiles(File directory, String [] files) throws IOException 
		{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		byte bytes[] = new byte[2048];
		for (String fileName : files) {
		FileInputStream fis = new FileInputStream(directory.getPath() +	File.separator+ fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		zos.putNextEntry(new ZipEntry(fileName));
		int bytesRead;
		while ((bytesRead = bis.read(bytes)) != -1) {
		zos.write(bytes, 0, bytesRead);
		}
		zos.closeEntry();
		bis.close();
		fis.close();
		}
		zos.flush();
		baos.flush();
		zos.close();
		baos.close();
		return baos.toByteArray();
		}
	
		//ActionContext.setAttribute("message", "folder has been download sucessfully ");
		

	



	//method to process request 
	/*Logger logger=Logger.getRootLogger();	
	public String processRequest() throws Exception 
	{
		String destinationDir="C:\\Users\\Nirmal\\Downloads";
	Logger logger=Logger.getRootLogger();	
	//read folder id...
	int id=Integer.parseInt(
			ActionContext.getParameter("id"));
	FolderDao dao=new FolderDao();
	Folder folder=dao.getById(id);
	//Remove folder form the file system...
	ActionContext.setAttribute("folder", folder);
	logger.info(folder.getName());
	fileUrl(folder.getName(),destinationDir);
	logger.info("hello hello hello hello hello hello hello hello hello hello hello hello");
	return "downloadFolder";
	}
	


	
	public static void fileUrl(String fAddress,String destinationDir)
	{
		Logger logger=Logger.getRootLogger();
		OutputStream outStream=null;
		URLConnection uCon=null;
		InputStream is=null;
		
		try{
			URL url;
			byte[] buf;
			int ByteRead,ByteWriter=0;
			url=new URL(fAddress);
			outStream =new BufferedOutputStream(new FileOutputStream(destinationDir));
			uCon=url.openConnection();
			is=uCon.getInputStream();
			buf=new byte[1024];
			while((ByteRead= is.read())!= -1)
			{
				outStream.write(ByteRead);
				//ByteWriter+=ByteRead;
				
			}
			
			logger.info("Download Sucessfully                  Download Sucessfully                     Download Sucessfully                  Download Sucessfully");	
		}
		catch(Exception e){e.printStackTrace();}
		finally{
			try{
				is.close();
				outStream.close();
			}
			catch(Exception e){e.printStackTrace();}		
		}
	}*/
}

