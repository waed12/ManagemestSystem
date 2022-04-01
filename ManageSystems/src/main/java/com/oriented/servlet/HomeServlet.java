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

import com.oriented.constant.constantInterface;
import com.oriented.db.TaskDB;
import com.oriented.tasks.Task;
import com.oriented.user.User;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Task> taskList = null;
	private HttpSession session;
	private User userSession;

	public HomeServlet() {
		super();

	}

	public void include(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("menu.html").include(request, response);
	}

	public void getTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		session = request.getSession(false);
		userSession = (User) session.getAttribute("User");
		taskList = TaskDB.getTask(userSession.getId());
		if (taskList.isEmpty() || taskList == null || taskList.size() == 0) {
			out.print("<p style=text-align:center>There are no tasks for you!</p>");
		} else {
			for (Task task : taskList) {
				out.println("</br>");
				out.print("<form action=EditTaskState>");
				out.print("<div style=text-align:Center>");
				out.println("<h1>Your Task is:" + task.getText() + "</h1>");
				out.println("<input type=radio name=stateradioButton value =Inprogress>InProgress");
				out.println("<input type=radio name=stateradioButton value =Done>Done");
				out.print("<tr><td colspan='2'><input type='submit' value='save '/></td></tr>");
				out.print("</div>");
				out.print("</form>");
			}

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		this.include(request, response);
		this.getTask(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
