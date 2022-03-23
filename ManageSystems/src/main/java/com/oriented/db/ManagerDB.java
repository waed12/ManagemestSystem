package com.oriented.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.oriented.user.Manager;

public class ManagerDB {

	  public static  Manager getId() {
		  Manager manager=new Manager();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select user_id from manager");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			if(rs.next()) {
			manager.setId(rs.getString(1));	
			}
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return manager;
	  }
	  public static Manager getManager(String id) {
		 Manager manager=new Manager();
		
		  try {
			
			Connection con=ConnectionDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("select user.name,user.user_id,user.city from manager INNER JOIN user where manager.user_id=user.user_id and manager.user_id='"+id+"'");
			ResultSet rs=(ResultSet) prepare.executeQuery();
			if(rs.next()) {
		    
			manager.setName(rs.getString(1));	
			manager.setId(rs.getString(2));
			manager.setCity(rs.getString(3));
	
			}

			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return manager;
	  }
}
