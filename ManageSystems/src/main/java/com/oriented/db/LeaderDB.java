package com.oriented.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.oriented.user.Leader;

public class LeaderDB {

	  public static List <Leader> getAllId() {
		 List <Leader> list=new ArrayList <Leader>();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select user_id from leader");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			while(rs.next()) {
		    Leader leader=new Leader();
			leader.setUser_Id(rs.getString(1));	
			list.add(leader);
			}
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
	  }  
	  public static List <Leader> getAllLeader() {
		 List <Leader> list=new ArrayList <Leader>();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select leader.leader_id,user.name,user.user_id,user.city from leader INNER JOIN user where leader.user_id=user.user_id ");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			while(rs.next()) {
		    Leader leader=new Leader();
			leader.setId(rs.getString(1));	
			leader.setName(rs.getString(2));
			leader.setUser_Id(rs.getString(3));
			leader.setCity(rs.getString(4));
			list.add(leader);
			}

			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
	  }
	  public static Leader getLeader(String id) {
		 Leader leader=new Leader();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select user.name,user.user_id,user.city from leader INNER JOIN user where leader.user_id=user.user_id and leader.user_id='"+id+"'");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			if(rs.next()) {
		    
			leader.setName(rs.getString(1));	
			leader.setId(rs.getString(2));
			leader.setCity(rs.getString(3));
	
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return leader;
	  }
	  public static int AddLeader(Leader leader) {
		 
		int result=0;
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("insert into user(user_id,name,password,city) values(?,?,?,?)");
			
			
		    prepare.setString(1, leader.getId());
		    prepare.setString(2, leader.getName());
		    prepare.setString(3, leader.getPassword());
		    prepare.setString(4, leader.getCity());
      
		    result=prepare.executeUpdate();
			

			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return result;
	  }
	  
}
