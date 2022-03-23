package com.oriented.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.oriented.db.ConnectionDB;
import com.oriented.db.DeveloperDB;
import com.oriented.db.LeaderDB;
import com.oriented.user.Developer;

/**
 * Servlet implementation class AddDeveloperServlet
 */
@WebServlet("/AddDeveloperServlet")
public class AddDeveloperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeveloperServlet() {
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
		Developer develop=new Developer();
		
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pass=request.getParameter("psw");
		String city=request.getParameter("city");
		
		develop.setName(name);
		develop.setId(id);
		develop.setPassword(pass);
		develop.setCity(city);
		
		 int result=DeveloperDB.AddDeveloper(develop); 
		 if(result>0) {
			 out.print("<p>Developer Added Successfully</p>");
			 request.getRequestDispatcher("AddDeveloper.html").forward(request, response);	
				try {
					Connection con=ConnectionDB.getConnection();
					PreparedStatement prepare;
					prepare = (PreparedStatement) con.prepareStatement("insert into developer(user_id,leader_id) values(?,?)");
				    prepare.setString(1, develop.getId());
				    prepare.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 out.print("sucess");
				
			
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
