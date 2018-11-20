package com.swinfosoft.jplug.actions;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

public class UploadJarAction implements Action {

	@Override
	public String processRequest() throws Exception {
		Logger logger=Logger.getRootLogger();
		HttpServletRequest request=(HttpServletRequest)
				ActionContext.getServletRequest();
		
		 FolderDao dao=new FolderDao();
		 int size=0,newsize=0;
		//checking if a file is uploaded.
		  if (MultipartFormDataRequest.isMultipartFormData(request))
	      {
			
		     MultipartFormDataRequest mrequest = 
		    		 new MultipartFormDataRequest(request);
		     //reading values of jarFolder parameter from
		     //Multipart request...
		 
		    
		     String foldername=mrequest.getParameter("jarFolder");
		        logger.info("++++++++++++++++++++++++++++++="+foldername);
		     Hashtable files = mrequest.getFiles();
	            if ( (files != null) && (!files.isEmpty()) )
	            {
	            //Creating object to receive uploaded image
	            UploadFile uf = (UploadFile)files.get("jarFile");
	            UploadBean bean=new UploadBean();
	            bean.setFolderstore(foldername);
			    bean.store(mrequest,"jarFile");
			    
			    logger.info(uf.getFileName()+
			    		" is uploaded at "+foldername);
			    logger.info(uf.getFileSize()
			    		+" bytes were uploaded.");
			   //add the file size to the folder size
			    
			    User user=(User)ActionContext.getAttribute("user",
						ActionContext.SessionScope);
			    logger.info("......................................................");
			    logger.info(user.getId() + "\t" +user.getName()+"\t "+user.getRole());
			    logger.info(uf.getFileName()+"\t"+uf.getFileSize());
			    logger.info("......................................................"+foldername);
			    logger.info("folder name is : "+foldername);
			   Folder fol=new Folder();
			   String fn=(foldername.substring(foldername.lastIndexOf("\\")+1));
			   logger.info("cutted name of folder from path : "+fn.trim());
				fol=dao.getByName(fn);
				if(fol !=null){
					logger.info("i am in if");
					logger.info(fol);
					if(fol.getSize()==0){
						 newsize=(int) (size+uf.getFileSize());
						 dao.updateFolderSize(newsize, foldername);
						 logger.info("my new size is ="+newsize);
						 logger.info("Sucessfully updated folder size in Database \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
					}
					else{
						 logger.info("i am in else");
						 newsize=(int) (size+fol.getSize()+uf.getFileSize());
						 dao.updateFolderSize(newsize, foldername);
						 logger.info("my new size is ="+newsize);
						 logger.info("Sucessfully updated folder size in Database \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
					}
					logger.info("hahahahahah              hahahahahaha                       hahahaha");
				}
				
		       }
	            ActionContext.setAttribute("message",
	            		"jar successfully uploaded...");
			   }    
		  else
		  {
			   ActionContext.setAttribute("message",
					   "jar couldn't be uploaded...");
		}
		  return "jarUploaded";
	}
}
