package com.oriented.DBlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.oriented.db.ConnectionDB;

/**
 * Application Lifecycle Listener implementation class DbListener
 *
 */
@WebListener
public class DbListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DbListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext context=sce.getServletContext();
    	String url=context.getInitParameter("URL");
    	String driver=context.getInitParameter("DriverName");
    	String username=context.getInitParameter("UserName");
    	String password=context.getInitParameter("Password");
    	
    	
    	 
    	ConnectionDB connection=new ConnectionDB(url,driver,username,password);
    }
	
}
