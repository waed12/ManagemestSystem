package com.oriented.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oriented.db.LeaderDB;
import com.oriented.user.Leader;

/**
 * Servlet implementation class ViewLeaderServlet
 */
@WebServlet("/ViewLeaderServlet")
public class ViewLeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLeaderServlet() {
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
           
		out.print("<a href='AddLeader.html'>"+"<p>Add New Leader</p>"+"</a>");
			          
			        out.println("<h1>Leader List</h1>");  
			          
			        List<Leader> list1=LeaderDB.getAllLeader();  
			       
			        out.print("<table border='1' width='auto'");  
			        out.print("<tr><th>Id</th><th>Name</th><th>User id</th><th>City</th><th>view developer</th><th>add task</th></tr>");  
			        for(Leader l:list1){ 
			        
			         out.print("<tr><td>"+l.getId()+"</td><td>"+l.getName()+"</td><td>"+l.getUser_Id()+"</td><td>"+l.getCity()+
			        		 "</td><td><a href='ViewDeveloper?id="+l.getUser_Id()+"'>view</a></td><td><a href='AddTask?id="+l.getUser_Id()+"'>add</a></td></tr>");
			        
			         
			         
			        }  
			        out.print("</table>");   
			        
			        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
