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

import com.oriented.user.User;

public class ProfilePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private User userSession;

	public ProfilePageServlet() {
		super();

	}

	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
	}

	public void ViewProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession(false);
		userSession = (User) session.getAttribute("User");

		request.setAttribute("FirstName", userSession.getFirstName());
		request.setAttribute("LastName", userSession.getLastName());
		request.setAttribute("Id", userSession.getId());
		request.setAttribute("City", userSession.getCity());
		request.setAttribute("Type", userSession.getType());

		this.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		this.ViewProfile(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
