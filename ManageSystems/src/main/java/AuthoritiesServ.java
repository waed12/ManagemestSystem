

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthoritiesServ
 */
@WebServlet("/AuthoritiesServ")
public class AuthoritiesServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthoritiesServ() {
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
		HttpSession session=request.getSession(false);
		String se=(String)session.getAttribute("user");
		
	    Manager manager=ManagerDB.getId(); 
	    out.print("</br></br>");
		if(manager.getId().equals(se)) {
          out.print("<div style=text-align:center>");
         
          out.print("<a href='AddLeader.html'>"+"<p>Add Leader</p>"+"</a>");
          out.print("<tr><th><a href='AddDeveloper.html'>"+"<p>Add Developer</p>"+"</a>");
          out.print("<a href='ViewTask'>"+"<p>View Tasks</p>"+"</a>");
         // out.print("<tr><th><a href='AddTask'>"+"<p>Add Task</p>"+"</a>");
          out.print("</div>");
  	     }


		List <Leader> list1=LeaderDB.getAllId();
		for(Leader leader:list1){  	 
			if(leader.getUser_Id().equals(se)) {
		          out.print("<div style=text-align:center>");
		          out.print("<a href='ViewDeveloper'>"+"<p>View Developer</p>"+"</a>");
		          out.print("<a href='ViewTask'>"+"<p>View Tasks</p>"+"</a>");
		        //  out.print("<tr><th><a href='AddTask'>"+"<p>Add Task</p>"+"</a>");
		          out.print("</div>");
				break;
			}
   
		}
//Developer 
		List <Developer> list2=DeveloperDB.getAllId();
		for(Developer develop:list2){  	 
			if(develop.getUser_Id().equals(se)) {
				 out.print("<div style=text-align:center>");
		         out.print("<a href='View Tasks'>"+"<p>View Tasks</p>"+"</a>");
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
