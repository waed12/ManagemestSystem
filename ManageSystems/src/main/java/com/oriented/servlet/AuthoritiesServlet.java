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
import com.oriented.user.User;

public class AuthoritiesServlet extends HttpServlet implements constantInterface {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private User userSession;

	public AuthoritiesServlet() {
		super();

	}

	public void include(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	public void ViewAuthorities(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession(false);
		userSession = (User) session.getAttribute("User");

		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("menu.html").include(request, response);
		HttpSession session = request.getSession(false);
		userSession = (User) session.getAttribute("User");
		if (userSession.getType().equals(managerType)) {
			out.print("<div style=text-align:Center>");
			out.print("<a href='AddEmployee.html'>" + "<p>Add Employee</p>" + "</a>");
			out.print("<tr><th><a href='AddTask.html'>" + "<p>Add Task</p>" + "</a>");
			out.print("<a href='ViewEmployee'>" + "<p>View Employee</p>" + "</a>");
			out.print("</div>");
		} else if (userSession.getType().equals(developerType)) {
			out.print("<tr><th><a href='AddTask.html'>" + "<p>Add Task</p>" + "</a>");
			out.print("<a href='ViewEmployee'>" + "<p>View Employee</p>" + "</a>");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.include(request, response);
		this.ViewAuthorities(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
