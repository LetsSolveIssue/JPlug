package com.swinfosoft.jplug.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.ActionContext;

public class ProgramRunner {

	public static String run(File f,String args,String rtv) throws Exception{
		
		String result="Execution failed, Compile program first.";
		String className=(String) ActionContext.getSession().getAttribute("className");
		Logger logger=Logger.getRootLogger();	
		logger.info(className);
		if(className!=null){
			String path=f.getPath();
		    
		    // when arguments passed.....
		   String rt[]=rtv.split("\n");
		   result="Successfully Executed.\n";
		   result+=callcmd("java "+className+" "+args ,null,path,rt);
		   String fileName=className+".java";
		   
		   
		    ActionContext.getSession().removeAttribute("className");
	    	return result;
	    	
		}
		else{
			return result;
		}
	    
	}
	
	public static String callcmd(String command,String[] args,String path,String[] rt) {
		String result="";
		try {
		      String line;
		      File dir = new File(path);
		      Process p=null;
		      String os=System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
		      	if (os.indexOf("win") >= 0) {
		      		p = Runtime.getRuntime().exec("cmd.exe /c "+command,args, dir);
		        } else if (os.indexOf("nux") >= 0) {
		        	String[] cmd=new String[]{"/bin/bash","-c",command};
		        	p = Runtime.getRuntime().exec(cmd,args, dir);
		        } 
		      
		      giveInputToProcess(p,rt);
		      
		      BufferedReader input1 = new BufferedReader (new InputStreamReader(p.getErrorStream()));
		      while ((line = input1.readLine()) != null) {
		    	  result+=line+"\n";
		      }
		      input1.close();
		      
		      if(result.equals("")){
		      BufferedReader input = new BufferedReader (new InputStreamReader(p.getInputStream()));
		      while ((line = input.readLine()) != null) {
		    	  result+=line+"\n";
		      }
		      input.close();
		      }
		    }
		    catch (Exception err) {
		    	result += err.toString()+"\n";
		    }
		return result;
	}
	
	public static void giveInputToProcess(Process process, String[] inputs) {
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
	    for (String input : inputs) {
	        try {
	            bw.write(input);
	            bw.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    try {
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
