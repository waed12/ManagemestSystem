package com.oriented.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.oriented.db.ConnectionDB;
import com.oriented.db.LeaderDB;
import com.oriented.tasks.Task;
import com.oriented.user.Leader;

/**
 * Servlet implementation class AddLeaderServlet
 */
@WebServlet("/AddLeaderServlet")
public class AddLeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

    public AddLeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *///
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("menu.html").include(request, response);
		Leader leader=new Leader();
		
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String password=request.getParameter("psw");
		String city=request.getParameter("city");
		
		leader.setName(name);
		leader.setUser_Id(id);
		leader.setPassword(password);
		leader.setCity(city);
		
		 int result=LeaderDB.AddLeader(leader); 
		 if(result>0) {
			 
			 out.print("<p>Leader Added Successfully</p>");
			 request.getRequestDispatcher("ViewLeaderServlet").forward(request, response);	

				try {
					Connection con=ConnectionDB.getConnection();
					PreparedStatement PrapereLeader;
					PrapereLeader = (PreparedStatement) con.prepareStatement("insert into leader(user_id) values(?)");
					PrapereLeader.setString(1, leader.getUser_Id());
					PrapereLeader.executeUpdate();
					
				    Task task=new Task();
		    	 	
					PreparedStatement PrepareTask=(PreparedStatement) con.prepareStatement("insert into task(user_id,text,state) values(?,?,?)");
					
					
					PrepareTask.setString(1, leader.getUser_Id());
					PrepareTask.setString(2, " ");
					PrepareTask.setString(3, " ");
					PrepareTask.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
