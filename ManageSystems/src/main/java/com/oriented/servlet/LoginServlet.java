package com.oriented.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.oriented.db.ConnectionDB;
import com.oriented.db.DeveloperDB;
import com.oriented.db.LeaderDB;
import com.oriented.db.ManagerDB;
import com.oriented.db.TaskDB;
import com.oriented.tasks.Task;
import com.oriented.user.Developer;
import com.oriented.user.Leader;
import com.oriented.user.Manager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *///
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		
		String username=request.getParameter("uname");
		String password=request.getParameter("psw");
		Connection con = null;
		
		
		try {
			
	        con=ConnectionDB.getConnection();
			//out.println("connected");
	        Statement stm=(Statement) con.createStatement();
	        ResultSet result=(ResultSet) stm.executeQuery("select * from user where User_id='"+username+"' and Password='"+password+"'");
	        if(result.next()) {
	        	
	    		Manager manager=ManagerDB.getId();
	    			            
			      if(manager.getId().equals(username)) {
		         	HttpSession session=request.getSession();
		                	session.setAttribute("user", username);
		                	request.getRequestDispatcher("HomeServlet").forward(request, response);
		                    	
			            }
			          
		            
		    	List <Leader> list1=LeaderDB.getAllId();
		    	 	for(Leader leader:list1){  
				            //out.println(leader.getId());	 
				          if(leader.getUser_Id().equals(username)) {
			                	HttpSession session=request.getSession();
			                	session.setAttribute("user", username);
			                	request.getRequestDispatcher("HomeServlet").forward(request, response);
			                	break;
				            }
				           
			           }
		    	//Developer 
			   List <Developer> list2=DeveloperDB.getAllId();
		    	 	for(Developer develop:list2){  
				           // out.println(develop.getUser_Id());	 
				          if(develop.getUser_Id().equals(username)) {
			                	HttpSession session=request.getSession();
			                	session.setAttribute("user", username);
			                	request.getRequestDispatcher("HomeServlet").forward(request, response);
			                	break;
				            }
				           
			           }
		    	

          
            } else {
	        	out.print("User name or password are error");
	        	request.getRequestDispatcher("Login.html").include(request, response);
	        }
	        
			
		
		}catch(Exception e) {
			out.println(e.getMessage());
			out.println("not connected");
		}
	}

}
