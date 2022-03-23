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

import com.oriented.db.TaskDB;
import com.oriented.tasks.Task;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
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
		
		List <Task> list=TaskDB.getTask(se);
		
		
        for(Task t:list){  
          Task task=new Task();
          out.println("</br>");
          out.print("<form action=EditTaskState>");
          out.print("<div style=text-align:Center>");
          out.println("<h1>Your Task is:"+t.getText()+"</h1>");
          out.print("<select name='state' style='width:150px'>");  
          out.print("<option>In progress</option>");  
          out.print("<option>Done</option>");  
          out.print("<option>Other</option>");  
          out.print("  </select>");
          out.print("<tr><td colspan='2'><input type='submit' value='save '/></td></tr>");  
          out.print("</div>");
          out.print("</form>");

          
        }  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    doGet(request,response);
	}

}
