package com.swinfosoft.jplug.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Calendar;

import com.swinfosoft.jplug.entity.Folder;
import com.swinfosoft.jplug.entity.PostMaster;
import com.swinfosoft.jplug.entity.User;

public class PostMasterDao extends AbstractDao {

	//Method to save the user post
	public void newPost(PostMaster postm) throws Exception
	{
	//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
	PreparedStatement stmt=con.prepareStatement(
	"insert into PostMaster (postedBy,postTitle,postContents,priority,postType,postStatus,datetime,userName,postCode)"
	+ " values(?,?,?,?,?,?,?,?,?)");
	//set the value of parameters.
	stmt.setInt(1,postm.getUserId());
	stmt.setString(2,postm.getTitle());
	stmt.setString(3,postm.getContent());
	stmt.setInt(4,postm.getPriority());
	stmt.setInt(5,postm.getType());
	stmt.setInt(6,postm.getStatus());
	stmt.setString(7,postm.getDate());
	stmt.setString(8,postm.getUserName());
	stmt.setString(9,postm.getCode());
	//execute the query
	stmt.executeUpdate();
	//close the connection
	con.close();
	}
	
	//Method to update the user post
	public void updatePost(PostMaster postm) throws Exception
		{
		//Connection is obtained.
Connection	con=getConnection();//super class method
	//Statement object is created to execute the query.
		PreparedStatement stmt=con.prepareStatement(
		"update PostMaster set postTitle=?,postContents=?,postCode=? where postId=?");
		//set the value of parameters.
		stmt.setString(1,postm.getTitle());
		stmt.setString(2,postm.getContent());
		stmt.setString(3,postm.getCode());
		stmt.setInt(4, postm.getId());
		//execute the query
		stmt.executeUpdate();
		//close the connection
		con.close();
		}
	//Method to load all the post..
	public List<PostMaster> viewPost() throws Exception
			{
		List<PostMaster> list=new ArrayList<PostMaster>();
		//List<PostMaster> list1=new ArrayList<PostMaster>();
		
	//Connection is obtained.
	Connection	con=getConnection();//super class method
	//Statement object is created to execute the query.
	PreparedStatement stmt=con.prepareStatement(
		"select * from PostMaster");
		//set the value of parameters.
		
		//execute the query
		ResultSet rset=stmt.executeQuery();
		//read the result of select query
		while(rset.next())//if user is found.
		{
			PostMaster postm=new PostMaster();
			//store record data in object
			postm.setId(rset.getInt(1));
			postm.setUserId(rset.getInt(2));
			postm.setTitle(rset.getString(3));
			postm.setContent(rset.getString(4));
			postm.setDate(rset.getString(6));
			postm.setStatus(rset.getInt(8));
			postm.setUserName(rset.getString(9));
			postm.setCode(rset.getString(10));
			list.add(postm);
		}
		/*ListIterator<PostMaster> itr=list.listIterator();
		while(itr.hasPrevious())
		{
			
			list1.add(itr.previous());
		}*/
		//close the connection
				con.close();
				//return the user object
				return list;
				}	
		//metod to load post by postid..
		public PostMaster getById(int postId) throws Exception
		{
			PostMaster postm=null;
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"select * from PostMaster where postId=?");
	//set the value of parameters.
	stmt.setInt(1, postId);
	//execute the query
	ResultSet rset=stmt.executeQuery();
	//read the result of select query
	if(rset.next())//if user is found.
	{
		postm=new PostMaster();
		//store record data in object
		postm.setUserName(rset.getString(9));
		postm.setId(rset.getInt(1));
		postm.setCode(rset.getString(10));
		postm.setTitle(rset.getString(3));
		postm.setContent(rset.getString(4));
	}
	//close the connection
	con.close();
	//return the user object
	return postm;
	}	

		


//Method to delete the user post
public void delete(int postid) throws Exception
		{
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"delete from postMaster where postId=?");
	//set the value of parameters.
	stmt.setInt(1, postid);
	//execute the query
	stmt.executeUpdate();
	//close the connection
	con.close();
	}
public void likePost(int userid) throws Exception
{
//Connection is obtained.
	int a=0;
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
"select postStatus from postMaster where postId=?");
//set the value of parameters.
stmt.setInt(1, userid);
ResultSet rset=stmt.executeQuery();
if(rset.next())
{
a=rset.getInt(1);
a++;
PreparedStatement stmt1=con.prepareStatement("update PostMaster set postStatus=? where postId=?");
stmt1.setInt(1,a);
stmt1.setInt(2,userid);
stmt1.executeUpdate();
}
//execute the query

//close the connection
con.close();	
}
//Method to save the users replies..
	public void saveReply(PostMaster postm) throws Exception
	{
	//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
	PreparedStatement stmt=con.prepareStatement(
	"insert into postanswer(postId,postedBy,postDate,postTitle,postContent,postCode)"
	+ " values(?,?,?,?,?,?)");
	//set the value of parameters.
	stmt.setInt(1,postm.getId());
	stmt.setString(2,postm.getUserName());
	stmt.setString(3,postm.getDate());
	stmt.setString(4,postm.getTitle());
	stmt.setString(5,postm.getContent());
	stmt.setString(6,postm.getCode());
	//execute the query
	stmt.executeUpdate();
	//close the connection
	con.close();
	}

	//Method to load the users replies..
		public List<PostMaster> showReply(int postid) throws Exception
		{
		//Connection is obtained.
			PostMaster postm=null;
			ArrayList<PostMaster> list=new ArrayList<PostMaster>();
	Connection	con=getConnection();//super class method
	//Statement object is created to execute the query.
		PreparedStatement stmt=con.prepareStatement("select * from postanswer where postId=?");
		stmt.setInt(1,postid);
	
		//execute the query
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{
			postm=new PostMaster();
			postm.setDate(rset.getString(3));
			postm.setUserName(rset.getString(2));
			postm.setTitle(rset.getString(4));
			postm.setContent(rset.getString(5));
			postm.setCode(rset.getString(6));
			list.add(postm);
		}
		con.close();
		return list;
		
		//close the connection
		
		}
		//Method to delete the user replies
		public void deleteReply(int postid) throws Exception
				{
		//Connection is obtained.
		Connection	con=getConnection();//super class method
		//Statement object is created to execute the query.
		PreparedStatement stmt=con.prepareStatement(
			"delete from postanswer where postId=?");
			//set the value of parameters.
			stmt.setInt(1, postid);
			//execute the query
			stmt.executeUpdate();
			//close the connection
			con.close();
			}

}
