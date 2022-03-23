package com.oriented.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTaskOneServlet
 */
@WebServlet("/AddTaskOneServlet")
public class AddTaskOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskOneServlet() {
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
		
		
		String id1=request.getParameter("id");
		
		out.print("<form action='AddTask2'>");
		
		out.print("<div style=text-align:Center>");
		out.print("<h1>Add new Task</h1>");
    	out.print("<label for=\"uid\"><b>User Id:</b></label>");
    	out.print("<input type='text' value="+id1+" name='id'></br>");	
    	out.print("<label for=\"text\"><b>text:</b></label>");
    	out.print("<input type='text' placeholder='Enter Text' name='text' required></br>");  
    	out.print("<button type=\"submit\">Add</button></br>");
    	out.print("</form>");
    	out.print("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
