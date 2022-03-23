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

import com.oriented.db.DeveloperDB;
import com.oriented.db.LeaderDB;
import com.oriented.db.ManagerDB;
import com.oriented.user.Developer;
import com.oriented.user.Leader;
import com.oriented.user.Manager;

/**
 * Servlet implementation class AuthoritiesServlet
 */
@WebServlet("/AuthoritiesServlet")
public class AuthoritiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthoritiesServlet() {
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
		request.getRequestDispatcher("menu.html").include(request, response);
		HttpSession session=request.getSession(false);
		String se=(String)session.getAttribute("user");
		
	    Manager manager=ManagerDB.getId(); 
	    out.print("</br></br>");
		if(manager.getId().equals(se)) {
          out.print("<div style=text-align:center>");
         
          out.print("<a href='AddLeader.html'>"+"<p>Add Leader</p>"+"</a>");
          out.print("<tr><th><a href='AddDeveloper.html'>"+"<p>Add Developer</p>"+"</a>");
          out.print("<a href='ViewAllLeader'>"+"<p>View All Leaders</p>"+"</a>");
          out.print("<tr><th><a href='ViewAllDeveloper'>"+"<p>View All Developers</p>"+"</a>");
          out.print("</div>");
  	     }


		List <Leader> list1=LeaderDB.getAllId();
		for(Leader leader:list1){  	 
			if(leader.getUser_Id().equals(se)) {
		          out.print("<div style=text-align:center>");
		          out.print("<a href='ViewDeveloper'>"+"<p>View Developer</p>"+"</a>");
		          out.print("</div>");
				break;
			}
   
		}
//Developer 
		List <Developer> list2=DeveloperDB.getAllId();
		for(Developer develop:list2){  	 
			if(develop.getUser_Id().equals(se)) {
				 out.print("<div style=text-align:center>");
		         out.print("</div>");
			}
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
