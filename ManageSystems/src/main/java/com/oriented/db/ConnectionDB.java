package com.oriented.db;

import java.sql.Connection;

import java.sql.DriverManager;

import javax.servlet.*;
import javax.servlet.http.*;

public class ConnectionDB  {
	
	private static Connection con;
	
	  public static Connection getConnection() {

			return con;

	     }
	
	public ConnectionDB(String url,String driver,String username,String password) {
		try {
			
			if(con==null) {
			Class.forName(driver);
	        con=DriverManager.getConnection(url,username,password); 
			System.out.println("connected");
			}
		    
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("not connected");
		}
	}
	
    
   
}


