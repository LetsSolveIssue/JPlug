package com.swinfosoft.jplug.actions;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.ConfigDao;
import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.jplug.util.ProgramCompiler;
import com.swinfosoft.mvc.web.*;

import java.io.*;
import java.util.*;

import javax.servlet.ServletResponse;

public class CompilerAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//
	
	logger.info("Below user code ");
	ArrayList list=new ArrayList();
	//reading db configuration
	String userCode=ActionContext.getParameter("code").trim();
	int folderId=Integer.parseInt((ActionContext.getParameter("id")));
	logger.info("Folder id :"+folderId);
	logger.info("list data :"+userCode);
	logger.info("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	logger.info(""+userCode.replaceAll("--",System.lineSeparator()));
	String uc=userCode.replaceAll("::::",System.lineSeparator());
	uc=uc.replaceAll("&lt;","<");
	uc=uc.replaceAll("&gt;",">");
	uc=uc.replaceAll("&amp;","&");
	String className = null;
		for(String sourceCode : userCode.split("::::", 0)){
			list.add(sourceCode);
			logger.info(sourceCode);
			
		}
		logger.info("I am before ListIterator  .....");
		int k=0;
		ListIterator itr=list.listIterator();
		while(itr.hasNext()){
			String s=itr.next().toString();
			if(s.equals("public static void main(String args[]){") || s.equals("public static void main(String args[])"))
			{
				/*while(itr.hasPrevious())
				{
					String s1=itr.previous().toString();
					logger.info("previous element is : "+s1);
					String sss=s1.toString();
					char ch[]=sss.toCharArray();
					char ch1[]=new char[ch.length];
				
						//k=0;
						for(int i=0;i<ch.length;i++)
						{
							if(ch[i]!=' ')
						ch1[k++]=ch[i];
							else{
								String cstr=new String(ch1);
								logger.info("class = = "+cstr);
								if(cstr.equals("class"))
								{
									logger.info("I am in if whthin if block ok ");
									System.out.println("class mil gaya yar hahahah hahahah hahahah");
								}
								k=0;
							}
						logger.info("ch[i] "+ch[i]);
						logger.info("ch1[k] "+ch1[k]);
						}
						for(int j=0;j<ch1.length;j++){
							System.out.println("value of ch1 is "+ch1[j]);
						}
						System.out.println("string word by word is "+sss);
					//if(s1.equals(""))
				}*/
				itr.previous();
				String s1=itr.previous().toString();
				className=s1.substring(s1.indexOf(" "),s1.indexOf("{")).trim();
				logger.info("class name is  :"+className);
				break;
			}
		
		}
		logger.info("I am after while....");
		//
		Folder folder=new Folder();
		FolderDao dao=new FolderDao();
		folder=dao.getById(folderId);
		//logger.info(folder.getId()+"\t"+folder.getName()+"\t"+folder.getParent()+"\t"+folder.getPath()+"\t"+folder.getUserId());
		File file=new File(folder.getPath()+File.separator+className.concat(".java"));
		File file1=new File(folder.getPath());
		logger.info(file.getAbsoluteFile()+"\t"+file.getAbsolutePath());
		FileWriter fw=new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw=new BufferedWriter(fw);
		//for(String sourceCode : userCode.split("--"))
		//bw.write(sourceCode+"\n");
		bw.write(uc+"\n");
		bw.close();
		logger.info("sucessfully done your work");
		
		
		//process to compile program
		logger.info("class name is :"+className);
		logger.info("folderpath name is :"+file1+"to store class file");
		String result=ProgramCompiler.compile(className, file1);
		ServletResponse response=ActionContext.getServletResponse();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print(result);
		out.close();
		logger.info("sucessfully  compiled ");
		
	return null;
	}

}
