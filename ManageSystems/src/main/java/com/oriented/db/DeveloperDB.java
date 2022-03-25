package com.oriented.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.oriented.tasks.Task;
import com.oriented.user.Developer;

public class DeveloperDB {
//
	  public static List <Developer> getAllId() {
		 List <Developer> list=new ArrayList <Developer>();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select user_id from developer");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			while(rs.next()) {
		    Developer develop=new Developer();
			develop.setUser_Id(rs.getString(1));	
			list.add(develop);
			}
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
	  }
	  public static List <Developer> getAllDeveloper(String id) {
		 List <Developer> list=new ArrayList <Developer>();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select developer.user_id,user.name,user.city,task.text,task.state from developer "
					+ "INNER JOIN user,task where developer.user_id=user.user_id and developer.user_id=task.user_id and developer.leader_id='"+id+"'");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			while(rs.next()) {
		    Developer develop=new Developer();
			develop.setUser_Id(rs.getString(1));	
			develop.setName(rs.getString(2));
			develop.setCity(rs.getString(3));
			develop.setText(rs.getString(4));
			develop.setState(rs.getString(5));

			list.add(develop);
			}

			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
	  }
	  public static Developer getDeveloper(String id) {
		 Developer develop=new Developer();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select user.name,user.user_id,user.city from developer INNER JOIN user where developer.user_id=user.user_id and developer.user_id='"+id+"'");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			if(rs.next()) {
		    
			develop.setName(rs.getString(1));	
			develop.setId(rs.getString(2));
			develop.setCity(rs.getString(3));
	
			}

			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return develop;
	  }
	  public static int AddDeveloper(Developer develop) {
			 
		int result=0;
		int result1=0;
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("insert into user(user_id,name,password,city) values(?,?,?,?)");
			
			
		    prepare.setString(1, develop.getId());
		    prepare.setString(2, develop.getName());
		    prepare.setString(3, develop.getPassword());
		    prepare.setString(4, develop.getCity());
      
		    result=prepare.executeUpdate();
		    
		    if(result>0) {
		      Task task=new Task();
		      PreparedStatement prepareTAsk=(PreparedStatement) con.prepareStatement("insert into task(user_id,text,task) values(?,?,?)");
		      prepare.setString(1, develop.getId());
		      result1=prepare.executeUpdate();
		    
		    }
			

			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return result;
	  }
}
