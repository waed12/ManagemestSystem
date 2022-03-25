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

import com.oriented.db.LeaderDB;
import com.oriented.db.ManagerDB;
import com.oriented.db.TaskDB;
import com.oriented.tasks.Task;
import com.oriented.user.Leader;
import com.oriented.user.Manager;

/**
 * Servlet implementation class AddTaskTwoServlet
 */
@WebServlet("/AddTaskTwoServlet")
public class AddTaskTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskTwoServlet() {
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
		HttpSession session=request.getSession(false);
		String se=(String)session.getAttribute("user");
		Task task=new Task();
		
		String id=request.getParameter("id");
		String text=request.getParameter("text");
		
		int result=TaskDB.EditTask(task,text,id);
		
		
		if(result>0) {
     task=TaskDB.getInformation(id);
     out.print("<p>Task added Successfully</p>");
     out.print("<p>User id="+task.getUser_Id()+"</p>");
     out.print("<p>User name="+task.getName()+"</p>");
     out.print("<p>The task="+task.getText()+"</p>");
     out.print("<p>The State="+"Has been sent"+"</p>");
         
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
