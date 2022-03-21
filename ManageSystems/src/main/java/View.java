

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
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
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
			  if(manager.getId().equals(se)) {
			          
			        out.println("<h1>Leader List</h1>");  
			          
			        List<Leader> list1=LeaderDB.getAllLeader();  
			       
			        out.print("<table border='1' width='auto'");  
			        out.print("<tr><th>Id</th><th>Name</th><th>User id</th><th>Task</th><th>view developer</th><th>add task</th></tr>");  
			        for(Leader l:list1){ 
			        
			         out.print("<tr><td>"+l.getId()+"</td><td>"+l.getName()+"</td><td>"+l.getUser_Id()+"</td><td>"+l.getText()+
			        		 "</td><td><a href='ViewDeveloper?id="+l.getUser_Id()+"'>view</a></td><td><a href='AddTask?id="+"'>add</a></td></tr>");
			         request.setAttribute("Id", l.getUser_Id());
			         
			        }  
			        out.print("</table>");   
			        out.println("<br><a href='Add leader'>Add New Leader</a>");
			       
			
			  }
	    
	          
         
  	   List <Leader> list1=LeaderDB.getAllId();
  	 	for(Leader leader:list1){  
			  if(leader.getUser_Id().equals(se)) {
			        out.println("<h1>Developer List</h1>");  
			        request.setAttribute("Id", se);
			        request.getRequestDispatcher("ViewDeveloper").forward(request, response);
			       
				break;            
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
