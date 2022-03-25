package com.oriented.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.oriented.db.ConnectionDB;
import com.oriented.db.DeveloperDB;
import com.oriented.db.LeaderDB;
import com.oriented.tasks.Task;
import com.oriented.user.Developer;
import com.oriented.user.Leader;

/**
 * Servlet implementation class AddDeveloperServlet
 */
@WebServlet("/AddDeveloperServlet")
public class AddDeveloperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeveloperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("menu.html").include(request, response);
		Developer develop=new Developer();
		
		
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pass=request.getParameter("psw");
		String city=request.getParameter("city");
		String leaderName=request.getParameter("Leader");
		
		
		develop.setName(name);
		develop.setUser_Id(id);
		develop.setPassword(pass);
		develop.setCity(city);
		develop.setLeader(leaderName);
		
		

		
		
		 int result=DeveloperDB.AddDeveloper(develop); 
		 
		 if(result>0) {
			

			 out.print("sucess");
			    if(result>0) {

					try {
						Connection con=ConnectionDB.getConnection();
						PreparedStatement PrepareDeveloper;
						PrepareDeveloper = (PreparedStatement) con.prepareStatement("insert into developer(user_id,leader_id) values(?,?)");
						PrepareDeveloper.setString(1, develop.getUser_Id());
				    	List <Leader> Leaderlist=LeaderDB.getAllId();
			    	 	for(Leader leader:Leaderlist){  	 
					          if(leader.getName().equals(develop.getLeader())) {
					        	  PrepareDeveloper.setString(2, leader.getUser_Id());
				                	break;
					            }
					           
				           }
					    Task task=new Task();
			    	 	PrepareDeveloper.execute();
						PreparedStatement PrepareTask=(PreparedStatement) con.prepareStatement("insert into task(user_id,text,state) values(?,?,?)");
						
						
						PrepareTask.setString(1, develop.getUser_Id());
						PrepareTask.setString(2, " ");
						PrepareTask.setString(3, " ");
						PrepareTask.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
