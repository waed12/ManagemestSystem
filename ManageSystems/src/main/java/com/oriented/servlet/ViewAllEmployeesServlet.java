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
import com.oriented.db.UserDB;
import com.oriented.user.Leader;
import com.oriented.user.User;

/**
 * Servlet implementation class ViewAllEmployeesServlet
 */
@WebServlet("/ViewAllEmployeesServlet")
public class ViewAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployeesServlet() {
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
           
			          
			        out.println("<h1>Employees List</h1>");  
			          
			        List<User> Userlist=UserDB.getAllEmployees();  
			       
			        out.print("<table border='1' width='auto'");  
			        out.print("<tr><th>User Id</th><th>Name</th><th>City</th><th>Task</th><th>Task State</th></tr>");  
			        for(User user:Userlist){ 
			        
			         out.print("<tr><td>"+user.getId()+"</td><td>"+user.getName()+"</td><td>"+user.getCity()+"</td><td>"+user.getText()+
			        		 "</td><td>"+user.getState()+"</td></tr>");
			        
			         
			         
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
