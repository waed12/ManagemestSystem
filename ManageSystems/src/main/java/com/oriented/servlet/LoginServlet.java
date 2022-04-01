package com.oriented.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.oriented.db.ConnectionDB;

import com.oriented.db.TaskDB;
import com.oriented.db.UserDB;
import com.oriented.tasks.Task;
import com.oriented.user.User;
import com.oriented.constant.constantInterface;

public class LoginServlet extends HttpServlet implements constantInterface {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	User user = new User();

	public LoginServlet() {
		super();

	}

	public void include(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("HomeServlet").forward(request, response);
	}

	public void getRequsetParameter(HttpServletRequest request, HttpServletResponse response) {
		userName = request.getParameter("userName");
		password = request.getParameter("password");
	}

	public void validation(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		if (userName.equals(null) || userName.trim().isEmpty() && password.trim().isEmpty() || password.equals(null)) {
			request.setAttribute("error", enteruserNameandPassword);
			this.include(request, response);
		} else if (userName.equals(null) || userName.trim().isEmpty()) {
			request.setAttribute("error", enteruserName);
			this.include(request, response);
		} else if (password.equals(null) || password.trim().isEmpty()) {
			request.setAttribute("error", enterPassword);
			this.include(request, response);
		} else {

			user = UserDB.userValidation(userName, password);
			if (user != null) {
				session.setAttribute("User", user);
				this.forward(request, response);
			} else {
				request.setAttribute("error", usernotExist);
				this.include(request, response);

			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

		response.setContentType("text/html");

		this.getRequsetParameter(request, response);
		this.validation(request, response);

	}
}
