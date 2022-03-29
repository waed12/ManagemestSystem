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
import com.oriented.tasks.Task;

public class EditTaskStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String stateRadioButton;
	Task task = new Task();

	public EditTaskStateServlet() {
		super();

	}

	public void getRequsetParameter(HttpServletRequest request, HttpServletResponse response) {
		stateRadioButton = request.getParameter("state");
	}

	public void editTaskState(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String se = (String) session.getAttribute("user");

		task.setState(stateRadioButton);

		int result = TaskDB.EditTaskState(task, se);

		if (result > 0) {
			out.print("<h1>Edit Successfully</h1>");
			request.getRequestDispatcher("HomeServlet").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		this.getRequsetParameter(request, response);
		this.editTaskState(request, response);
	}

}
