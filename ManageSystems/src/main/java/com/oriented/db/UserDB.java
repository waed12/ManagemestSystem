package com.oriented.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.oriented.user.Leader;
import com.oriented.user.User;

public class UserDB {
	//
	  public static Connection getConnection(){  
			Connection con = null;

			
			try {
				Class.forName("com.mysql.jdbc.Driver");
		        con=DriverManager.getConnection("jdbc:mysql://localhost/managesystems","root",""); 
				System.out.println("connected");
			    
			}catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("not connected");
			}
			return con;
	    }  
	  public static List <User> getAllEmployees() {
		 List <User> Userlist=new ArrayList <User>();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select user.user_id,user.name,user.city,task.text,task.state from user INNER JOIN task where user.user_id=task.user_id ");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			while(rs.next()) {
		    User user=new User();
			user.setId(rs.getString(1));	
			user.setName(rs.getString(2));
			user.setCity(rs.getString(3));
			user.setText(rs.getString(4));
			user.setState(rs.getString(5));
			Userlist.add(user);
			}

			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return Userlist;
	  }
}
