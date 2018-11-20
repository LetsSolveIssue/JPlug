package com.swinfosoft.jplug.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class ConfigDao extends AbstractDao {

	Logger logger=Logger.getRootLogger();
	public boolean isConfigured()
	{
		if(prop.getProperty("user")==null)
			return false;
		else
			return true;
	}
	public void configure(String user,String pass,
			String db) throws Exception
	{
		Connection con=getConnection();
		Statement stmt=con.createStatement();
		logger.info("creating user...");
		PreparedStatement stmt1=
				con.prepareStatement("CREATE USER ? @localhost");
		stmt1.setString(1, user);
		stmt1.execute();
		logger.info("User created, setting password...");
		PreparedStatement stmt2=
				con.prepareStatement(
		"SET PASSWORD FOR ? @localhost = PASSWORD(?)");
		stmt2.setString(1,user);
		stmt2.setString(2,pass);
		stmt2.execute();
		logger.info("Password Set, creating Db");
		String dbQuery="CREATE DATABASE "+db;
		stmt.execute(dbQuery);
		logger.info("Database created, granting all prevlilges to "+user+" for the db...");
		String prQuery="GRANT ALL ON "+db+".* TO "+user+" @localhost";
		stmt.execute(prQuery);
		logger.info("Previliges granted.");
		con.close();
		//set user,password to the properties...
		prop.setProperty("user",user);
		prop.setProperty("password", pass);
		String newUrl="jdbc:mysql://localhost:3306/"+db;
		prop.setProperty("url", newUrl);
		//write updated properties to the db.properties file...
		saveProperties();
		//create database tables...
		createTables();
	}
	
	private void createTables() throws Exception
	{
	logger.info("loading table queries...");
	String url=AbstractDao.class.getResource("/tables.sql").getPath();
	FileInputStream fin=new FileInputStream(url);
	byte a[]=new byte[fin.available()];
	fin.read(a);
	String Queries=new String(a);
	StringTokenizer str=
			new StringTokenizer(Queries,"/");
	Connection con=getConnection();
	Statement stmt=con.createStatement();
	logger.info("generating tables...");
	while(str.hasMoreElements())
	{
		String query=str.nextToken();
		stmt.execute(query);
	}
	con.close();
	logger.info("tables successfully generated.");
	}
}






