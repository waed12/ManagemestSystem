package com.oriented.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oriented.db.DeveloperDB;
import com.oriented.db.LeaderDB;
import com.oriented.db.ManagerDB;
import com.oriented.user.Developer;
import com.oriented.user.Leader;
import com.oriented.user.Manager;

/**
 * Servlet implementation class ViewDeveloperServlet
 */
@WebServlet("/ViewDeveloperServlet")
public class ViewDeveloperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDeveloperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("menu.html").include(request, response);
		HttpSession session=request.getSession(false);
		String se=(String)session.getAttribute("user");
		
		Manager manager=ManagerDB.getId();
		if(manager.getId().equals(se)) {
			
			out.print("<a href='AddDeveloper.html'>"+"<p>Add New Developer</p>"+"</a>");
			out.println("<h1>Developer List</h1>"); 
		
			String id=request.getParameter("id");
		
		
			List<Developer> developerList=DeveloperDB.getAllDeveloper(id);  
        
			out.print("<table border='1' width='auto'>");  
			out.print("<tr><th>Id</th><th>Name</th><th>User id</th><th>City</th><th>add task</th></tr>");  
			for(Developer d:developerList){ 
				out.print("<tr><td>"+d.getId()+"</td><td>"+d.getName()+"</td><td>"+d.getUser_Id()+"</td><td>"+d.getCity()+
						"</td><td><a href='AddTask?id="+d.getUser_Id()+"'>add</a></td></tr>");  
				out.print("</table>");  
	   }
	}
		
		
		List <Leader> leaderList=LeaderDB.getAllId();
		for(Leader leader:leaderList){  	 
			if(leader.getUser_Id().equals(se)) {
				out.println("<h1>Developer List</h1>"); 
		        List<Developer> developerList=DeveloperDB.getAllDeveloper(se);  
		        out.print("<table border='1' width='auto'>");  
		        out.print("<tr><th>Id</th><th>Name</th><th>User id</th><th>City</th><th>add task</th></tr>");  
		        for(Developer d:developerList){  
		        out.print("<tr><td>"+d.getId()+"</td><td>"+d.getName()+"</td><td>"+d.getUser_Id()+"</td><td>"+d.getCity()+
		      		 "</td><td><a href='AddTask?id="+d.getUser_Id()+"'>add</a></td></tr>");  
		        }  
		        out.print("</table>"); 
				break;
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
