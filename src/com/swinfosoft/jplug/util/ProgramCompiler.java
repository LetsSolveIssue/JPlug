package com.swinfosoft.jplug.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.ActionContext;

public class ProgramCompiler {
	
	public static String compile(String cname,File f) throws Exception
	{
		Logger logger=Logger.getRootLogger();
		logger.info("In compile method cname is : "+cname);
		logger.info("In compile method file is  : "+f);
		 String ERROR="Compilation Failed.";
		 String SUCCESS="Successfully Compiled.";
		 String result="";
		 //assign source code by reading from the file
		 String program =null;
		 String filePath=f.getPath();
			 result=callcmd("javac "+cname+".java",null,filePath);
			 ERROR=ERROR+"\n"+result;
		 
	    if(!result.equals(""))
			 return ERROR;
	    else{
	    	ActionContext.getSession().setAttribute("className",cname);
	    	return SUCCESS;
	    }
	}

	public static String callcmd(String command,String[] args,String path){
		String result="";
		try {
		      String line;
		      File dir = new File(path);

		    Process p=null;
		    String os=
		    System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
		      	if (os.indexOf("win") >= 0) {
		      		p = Runtime.getRuntime().exec(
		      				"cmd.exe /c "+command,args, dir);
		        } else if (os.indexOf("nux") >= 0) {
		        	String[] cmd=new String[]
		        			{"/bin/bash","-c",command};
		        	p = Runtime.getRuntime().exec(
		        			cmd,args, dir);
		        } 
		      
		      BufferedReader input = new BufferedReader (
		    		  new InputStreamReader(p.getErrorStream()));
		      
		      while ((line = input.readLine()) != null) {
		    	  result+=line+"\n";
		      }
		      input.close();
		      
		    }
		    catch (Exception err) {
		    	result += err.toString()+"\n";
		    }
		return result;
	}
	
	public static String parseSourceCode(String str)
	{
		final char allowed[]={';','+','-','/','*','=','!','<','>','(',')','{','}',']','[','&','|','%'};
		final int upperStart=65;
		final int upperEnd=90;
		final int lowerStart=97;
		final int lowerEnd=122;
		final int digitStart=47;
		final int digitEnd=56;
		char[] src=str.toCharArray();
		char[] target=new char[src.length];
		int j=0;
		for(int i=0;i<src.length;i++)
		{
			//if char then write to target
			if((src[i]>=upperStart && src[i] <=upperEnd )
					|| (src[i]>=lowerStart && src[i] <=lowerEnd))
			{
				target[j++]=src[i];
			}
			//if digit then write to the target
			else if(src[i]>=digitStart && src[i] <=digitEnd )
			{
				target[j++]=src[i];	
			}
			//if allowed char write to the target	
		}
		return null;
	}
}
