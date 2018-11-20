package com.swinfosoft.jplug.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.User;

public class FolderDao extends AbstractDao {

		
//Method to load a folder using id
public Folder getById(int folderId) throws Exception
		{
	Folder folder=null;
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"select * from FolderMaster where folderId=?");
	//set the value of parameters.
	stmt.setInt(1, folderId);
	//execute the query
	ResultSet rset=stmt.executeQuery();
	//read the result of select query
	if(rset.next())//if user is found.
	{
		folder=new Folder();
		//store record data in object
		setFields(folder,rset);
	}
	//close the connection
	con.close();
	//return the user object
	return folder;
	}	

//Method to load  the folders of a user
		public Folder getByName(String folderName) throws Exception
				{
			Logger logger=Logger.getRootLogger();
			logger.info("I am top of the getByName method in folder dao");
			
		//Connection is obtained.
		Connection	con=getConnection();//super class method
		//Statement object is created to execute the query.
		PreparedStatement stmt=con.prepareStatement(
			"select * from FolderMaster where folderName=?");
			//set the value of parameters.
			stmt.setString(1, folderName);
			
			//execute the query
			ResultSet rset=stmt.executeQuery();
			//read the result of select query
		
				Folder folder=new Folder();
				//store record data in object
				if(rset.next()){
				folder.setId(rset.getInt(1));
				folder.setUserId(rset.getInt(2));
				folder.setName(rset.getString(3));
				folder.setPath(rset.getString(4));
				folder.setParent(rset.getString(5));
				folder.setEmpty(rset.getBoolean(6));
				folder.setSize(rset.getInt(7));
				}
			
			//close the connection
			con.close();
			//return the user object
			logger.info("I am bottom of the getByName method in folder dao");
			return folder;
			}	
		
//Method to load all the folders of a user
public List<Folder> allFolders(int userId) throws Exception
		{
	List<Folder> list=new ArrayList<Folder>();
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"select * from FolderMaster where userId=?");
	//set the value of parameters.
	stmt.setInt(1, userId);
	
	//execute the query
	ResultSet rset=stmt.executeQuery();
	//read the result of select query
	while(rset.next())//if user is found.
	{
		Folder folder=new Folder();
		//store record data in object
		setFields(folder,rset);
		list.add(folder);
	}
	//close the connection
	con.close();
	//return the user object
	return list;
	}	

//Method to save a folder
	public void save(Folder folder) throws Exception
	{
	//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
	PreparedStatement stmt=con.prepareStatement(
	"insert into FolderMaster (userId,folderName,"
	+ "folderPath,parentPath,empty,size)"
	+ " values(?,?,?,?,?,?)");
	//set the value of parameters.
	stmt.setInt(1,folder.getUserId());
	stmt.setString(2,folder.getName());
	stmt.setString(3,folder.getPath());
	stmt.setString(4,folder.getParent());
	stmt.setBoolean(5,folder.isEmpty());
	stmt.setInt(6,folder.getSize());
	//execute the query
	stmt.executeUpdate();
	//close the connection
	con.close();
	}

	//Method to delete a folder
		public void delete(int folderId) throws Exception
		{
		//Connection is obtained.
	Connection	con=getConnection();//super class method
	//Statement object is created to execute the query.
		PreparedStatement stmt=con.prepareStatement(
		"delete from FolderMaster where folderId=?");
		//set the value of parameters.
		stmt.setInt(1,folderId);
		//execute the query
		stmt.executeUpdate();
		//close the connection
		con.close();
		}
		public void deleteByName(String folderName) throws Exception
		{
		//Connection is obtained.
	Connection	con=getConnection();//super class method
	//Statement object is created to execute the query.
		PreparedStatement stmt=con.prepareStatement(
		"delete from FolderMaster where folderName=?");
		//set the value of parameters.
		stmt.setString(1,folderName);
		//execute the query
		stmt.executeUpdate();
		//close the connection
		con.close();
		}
		
		private void setFields (Folder folder,ResultSet rset) 
				throws Exception 
		{
			
			folder.setId(rset.getInt(1));
			folder.setUserId(rset.getInt(2));
			folder.setName(rset.getString(3));
			folder.setPath(rset.getString(4));
			folder.setParent(rset.getString(5));
			folder.setEmpty(rset.getBoolean(6));
			folder.setSize(rset.getInt(7));
		}
		//Method to rename folder in database 
		public void renameFolder(String newpathoffolder,String s,int id) throws Exception{
			Folder folder=null;
			Connection	con=getConnection();//super class method
			//Statement object is created to execute the query.
			PreparedStatement stmt=con.prepareStatement("UPDATE foldermaster SET folderName=?,folderPath=?  WHERE folderId=?");
			stmt.setString(1,s);
			stmt.setString(2, newpathoffolder);
			stmt.setInt(3, id);
			stmt.executeUpdate();
			con.close();
			
			//return folder;
		}
		//Method to renamesubfolder in database
				public void renameSubFolder(String np,String pp,String op ) throws Exception{
					Folder folder=null;
					Connection	con=getConnection();//super class method
					//Statement object is created to execute the query.
					PreparedStatement stmt=con.prepareStatement("UPDATE foldermaster SET folderPath=?, parentPath=? WHERE folderPath=?");
					stmt.setString(1,np);
					stmt.setString(2, pp);
					stmt.setString(3, op);
					stmt.executeUpdate();
					con.close();
					
					//return folder;
				}
		//Update FolderSize in the Database
		
		public void updateFolderSize(int fs,String fp) throws Exception{
			
			Connection	con=getConnection();//super class method
			//Statement object is created to execute the query.
			logger.info("udating .................");
			logger.info("this is file sie in folderdao  :"+fs);
			logger.info("this is file name in folderdao :"+fp);
			PreparedStatement stmt=con.prepareStatement("UPDATE foldermaster SET size=?  WHERE folderPath=?");
			stmt.setInt(1,fs);
			stmt.setString(2, fp);
			stmt.executeUpdate();
			logger.info("udaed .......");
			con.close();
			
			//return folder;
		}
}









