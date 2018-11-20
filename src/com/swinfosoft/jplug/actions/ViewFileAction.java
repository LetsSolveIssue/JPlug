package com.swinfosoft.jplug.actions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.dao.FolderDao;
import com.swinfosoft.jplug.dao.UserDao;
import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;
import com.swinfosoft.mvc.web.*;

public class ViewFileAction implements Action {
	
	public String processRequest() throws Exception
	{

		Logger log=Logger.getRootLogger();
		Logger logger=Logger.getRootLogger();	
		String jPath=ActionContext.getParameter("path");
		String fileContent="\t";
		logger.info("file path is "+jPath);
		if(jPath!=null)
		{
			System.out.println("returning to display");
			try
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(jPath)));
				//PrintStream pr=new PrintStream(new FileOutputStream(arr[1]));
				while(true)
				{
					String line=br.readLine();
					if(line!=null)
					{
					fileContent=fileContent+"\n"+line;
					}
					if(line==null)
					{
						break;
					}
					
				}
				
				br.close();
			}
			catch(Exception ex)
			{
				System.out.println("Exception Occured::"+ex);
			}
			int k=0;
			String jf[]=fileContent.split("\n");
			String jft[]=new String[jf.length];
			for(int i=0;i<jf.length;i++)
			{
				if(jf[i].equals(" "))
				{
				i++;	
				}
				else
				{
				System.out.println(jf[i]);
				jft[k++]=jf[i];
				}
			}
			//ActionContext.setAttribute("codeJava", jft,ActionContext.ApplicationScope);
			//for(int i=0;i<jf.length;i++)
			//System.out.println(jf[i]);
			ActionContext.setAttribute("javafilecode", jft);
			
			ServletResponse response=ActionContext.getServletResponse();
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print(fileContent);
			out.close();
	}	
		return null;
	}	
}



