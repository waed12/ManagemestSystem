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

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();

	}

	public void getTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		String se=(String)session.getAttribute("user");
    	List <Task> Tasklist=TaskDB.getTask(se);
        for(Task t:Tasklist){  
          out.println("</br>");
          out.print("<form action=EditTaskState>");
          out.print("<div style=text-align:Center>");
          out.println("<h1>Your Task is:"+t.getText()+"</h1>");  
		  out.println("<input type=radio name=state value =Recieved>Recieved");
		  out.println("<input type=radio name=state value =Inprogress>InProgress");
		  out.println("<input type=radio name=state value =Done>Done");
          out.print("<tr><td colspan='2'><input type='submit' value='save '/></td></tr>");  
          out.print("</div>");
          out.print("</form>");
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.getRequestDispatcher("menu.html").include(request, response);
		this.getTask(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
