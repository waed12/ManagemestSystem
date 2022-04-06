package com.oriented.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oriented.db.TaskDB;
import com.oriented.tasks.TaskBean;
import com.oriented.user.User;

public class EditTaskStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String stateradioButton;
	private HttpSession session;
	private User userSession;
	TaskBean task = new TaskBean();

	public EditTaskStateServlet() {
		super();

	}

	public void getRequsetParameter(HttpServletRequest request, HttpServletResponse response) {
		stateradioButton = request.getParameter("stateradioButton");
	}

	public void include(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Home.jsp").include(request, response);
	}

	public void editTaskState(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		session = request.getSession(false);
		userSession = (User) session.getAttribute("User");

		task.setState(stateradioButton);

		int result = TaskDB.EditTaskState(task, userSession.getId());

		if (result > 0) {

			this.include(request, response);
			out.print("<P style=text-align:center>Your Task state now is: " + task.getState() + "<p1>");

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		this.getRequsetParameter(request, response);
		this.editTaskState(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
