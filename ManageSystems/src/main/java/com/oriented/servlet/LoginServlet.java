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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userName;
	String password;
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

	public void validatin(HttpServletRequest request, HttpServletResponse response, String userName, String password)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		if (userName.trim().isEmpty() && password.trim().isEmpty()) {
			request.setAttribute("error", "enter user name and password");
			this.include(request, response);
		} else if (userName.trim().isEmpty()) {
			request.setAttribute("error", "enter user name");
			this.include(request, response);
		} else if (password.trim().isEmpty()) {
			request.setAttribute("error", "enter password");
			this.include(request, response);
		} else {
			user = UserDB.userValidation(userName, password);
			if (UserDB.flag == true) {
				if (user.getType().equals("manager")) {
					session.setAttribute("user", userName);
					this.forward(request, response);
				} else if (user.getType().equals("leader")) {
					session.setAttribute("user", userName);
					this.forward(request, response);
				} else if (user.getType().equals("developer")) {
					session.setAttribute("user", userName);
					this.forward(request, response);
				}
			} else {
				request.setAttribute("error", "user not exist, try again");
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
		this.validatin(request, response, userName, password);

	}
}
