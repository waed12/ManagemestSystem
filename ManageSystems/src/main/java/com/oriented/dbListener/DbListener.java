package com.oriented.dbListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.oriented.db.ConnectionDB;


public class DbListener implements ServletContextListener {


	public DbListener() {
	
	}

	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}


	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext context = sce.getServletContext();
		String url = context.getInitParameter("URL");
		String driver = context.getInitParameter("DriverName");
		String username = context.getInitParameter("UserName");
		String password = context.getInitParameter("Password");

		ConnectionDB connection = new ConnectionDB(url, driver, username, password);
	}

}
