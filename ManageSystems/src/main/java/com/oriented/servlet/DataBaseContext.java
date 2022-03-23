package com.oriented.servlet;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class DataBaseContext
 */
@WebServlet("/DataBaseContext")
public class DataBaseContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataBaseContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 *///
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		
		
		try {
			ServletContext context=this.getServletContext();
			
			Class.forName(context.getInitParameter("DriverName"));
			Connection con=(Connection) DriverManager.getConnection(context.getInitParameter("Url"),context.getInitParameter("UserName"),context.getInitParameter("Password"));
			context.setAttribute("conn", con);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		Connection con=(Connection) this.getServletContext().getAttribute("conn");
		
		if(con!=null && !con.isClosed()) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
