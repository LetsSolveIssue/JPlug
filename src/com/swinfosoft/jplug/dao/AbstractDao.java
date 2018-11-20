package com.swinfosoft.jplug.dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public abstract class AbstractDao {

	static Properties prop;
	static Logger logger=Logger.getRootLogger(); 
	static
	{
		prop=new Properties();
		try
		{
		InputStream in=
			AbstractDao.class.getResourceAsStream("/db.properties");
		prop.load(in);
		logger.info("properties loaded.");
		}catch(Exception ex)
		{
			logger.error(ex);
		}
	}

	public void saveProperties() throws Exception
	{
	String url=AbstractDao.class.getResource("/db.properties").getPath();
	logger.info("db properties are saved at: "+url);			
	FileOutputStream out=new FileOutputStream(url);
	prop.store(out, "db properties configured by the user.");
	}
	
public Connection getConnection() throws Exception
{
Connection con=null;

		//To create a database connection for MySql
		Class.forName(prop.getProperty("driverClass"));
		String url=prop.getProperty("url");
		String user=prop.getProperty("user");
		String pass=prop.getProperty("password");
		if(user==null)
		con=DriverManager.getConnection(url);
		else 
		con=
		DriverManager.getConnection(url,user,pass);
		
		return con;
	}
}


