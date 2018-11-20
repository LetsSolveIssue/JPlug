package com.swinfosoft.jplug.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.jplug.entity.User;

public class UserDao extends AbstractDao {

	Logger logger=Logger.getRootLogger();
	//Method to save the user
	public void save(User user) throws Exception
	{
	//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
	PreparedStatement stmt=con.prepareStatement(
	"insert into UserMaster (name,mailid,password,securityquestion,securityanswer,role)"
	+ " values(?,?,?,?,?,?)");
	//set the value of parameters.
	stmt.setString(1,user.getName());
	stmt.setString(2,user.getMailId());
	stmt.setString(3,user.getPassword());
	stmt.setString(4,user.getSecurityQuestion());
	stmt.setString(5,user.getSecurityAnswer());
	stmt.setInt(6,user.getRole());
	//execute the query
	stmt.executeUpdate();
	//close the connection
	con.close();
	}
	
	//Method to update the user
	public void update(User user) throws Exception
		{
		//Connection is obtained.
Connection	con=getConnection();//super class method
	//Statement object is created to execute the query.
		PreparedStatement stmt=con.prepareStatement(
		"update usermaster set name=? , mailId=? , password=? , securityquestion=? , securityanswer=? , role=? where userId=?");
		//set the value of parameters.
		stmt.setString(1,user.getName());
		stmt.setString(2,user.getMailId());
		stmt.setString(3,user.getPassword());
		stmt.setString(4,user.getSecurityQuestion());
		stmt.setString(5,user.getSecurityAnswer());
		stmt.setInt(6,user.getRole());
		stmt.setInt(7,user.getId());
		//execute the query
		stmt.executeUpdate();
		//close the connection
		/*logger.info(":::::user.getId():::::"+user.getId());
		logger.info("::::getName()::::::"+user.getName());
		logger.info(":::::getMailId():::::"+user.getMailId());
		logger.info(":::::getPassword():::::"+user.getPassword());
		logger.info(":::::getSecurityQuestion():::::"+user.getSecurityQuestion());
		logger.info(":::::getSecurityAnswer():::::"+user.getSecurityAnswer());
		logger.info(":::::user.getRole():::::"+user.getRole());*/
		con.close();
		}
	
	//Method to update the user
		public void resetPassword(String p,String mid) throws Exception
			{
			//Connection is obtained.
	Connection	con=getConnection();//super class method
		//Statement object is created to execute the query.
			PreparedStatement stmt=con.prepareStatement(
			"update usermaster set password=? where mailId=?");
			//set the value of parameters.
			stmt.setString(1,p);
			stmt.setString(2,mid);
			
			//execute the query
			stmt.executeUpdate();
			//close the connection
			logger.info("sucessfully reset your password ");
			con.close();
			}
	
//Method to delete the user
public void delete(int userId) throws Exception
		{
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"delete from UserMaster where id=?");
	//set the value of parameters.
	stmt.setInt(1, userId);
	//execute the query
	stmt.executeUpdate();
	//close the connection
	con.close();
	}
		
//Method to load a user using id
public User getById(int userId) throws Exception
		{
	User user=null;
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"select * from UserMaster where userId=?");
	//set the value of parameters.
	stmt.setInt(1, userId);
	//execute the query
	ResultSet rset=stmt.executeQuery();
	//read the result of select query
	if(rset.next())//if user is found.
	{
		user=new User();
		//store record data in object
		user.setId(rset.getInt(1));
		user.setName(rset.getString(2));
		user.setMailId(rset.getString(3));
		user.setPassword(rset.getString(4));
		user.setSecurityQuestion(rset.getString(5));
		user.setSecurityAnswer(rset.getString(6));
		user.setRole(rset.getInt(7));
	}
	//close the connection
	con.close();
	//return the user object
	return user;
	}	

//Method to find user using mailId and password
public boolean findUser(User user) throws Exception
		{
	boolean flag=false;
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"select * from usermaster where mailId=? and password=?");
	//set the value of parameters.
	stmt.setString(1, user.getMailId());
	stmt.setString(2, user.getPassword());
	//execute the query
	ResultSet rset=stmt.executeQuery();
	//read the result of select query
	if(rset.next())//if user is found.
	{
		flag=true;
		//store record data in object
		user.setId(rset.getInt(1));
		user.setName(rset.getString(2));
		user.setRole(rset.getInt(7));
	}
	//close the connection
	con.close();
	//return the user object
	return flag;
	}
//find mail_id
public User findMailId(String mailid) throws Exception
{
	User user=new User();
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
logger.info(":::::user email id is "+mailid);
PreparedStatement stmt=con.prepareStatement("select * from usermaster where mailId=?");
//set the value of parameters.
stmt.setString(1, mailid);
//execute the query
ResultSet rset=stmt.executeQuery();
//read the result of select query
if(rset.next())//if user is found.
{
//store record data in object
user.setId(rset.getInt(1));
user.setName(rset.getString(2));
user.setMailId(rset.getString(3));
user.setPassword((rset.getString(4)));
user.setSecurityQuestion((rset.getString(5)));
user.setSecurityAnswer((rset.getString(6)));
user.setRole(rset.getInt(7));
}

//close the connection
con.close();
//return the user object
return user;
}
//select All users
public List<User> selectAllUsers()throws Exception{
	
	
	List<User>list=new ArrayList<User>();
	
	
	//Connection is obtained.
	Connection	con=getConnection();//super class method
	PreparedStatement stmt=con.prepareStatement("select * from usermaster");
	ResultSet rset=stmt.executeQuery();
	//read the result of select query
	while(rset.next())//if user is found.
	{
		User user=new User();
	//store record data in object
	user.setId(rset.getInt(1));
	user.setName(rset.getString(2));
	user.setMailId(rset.getString(3));
	user.setPassword((rset.getString(4)));
	user.setSecurityQuestion((rset.getString(5)));
	user.setSecurityAnswer((rset.getString(6)));
	user.setRole(rset.getInt(7));
	
	list.add(user);
	logger.info(":::::user.getId():::::"+user.getId());
	logger.info("::::getName()::::::"+user.getName());
	logger.info(":::::getMailId():::::"+user.getMailId());
	logger.info(":::::getPassword():::::"+user.getPassword());
	logger.info(":::::getSecurityQuestion():::::"+user.getSecurityQuestion());
	logger.info(":::::getSecurityAnswer():::::"+user.getSecurityAnswer());
	logger.info(":::::user.getRole():::::"+user.getRole());
	}

	return list;
	
}
}