package com.oriented.db;
import java.sql.Connection;
import java.sql.DriverManager;

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
}
