

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
 * Servlet implementation class ViewTask
 */
@WebServlet("/ViewTask")
public class ViewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTask() {
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
			
		out.println("<h1>Task List</h1>"); 
	
		
        List<Task> list2=TaskDB.getAllTask();  
        
        out.print("<table border='1' width='auto'>");  
        out.print("<tr><th>User id</th><th>Username</th><th>Task</th></tr>");  
        for(Task t:list2){  
        out.print("<tr><td>"+t.getUser_Id()+"</td><td>"+t.getName()+"</td><td>"+t.getText()+"</td></tr>");  
        }  
        out.print("</table>");  
	   }
		List <Leader> list1=LeaderDB.getAllId();
		for(Leader leader:list1){  	 
			if(leader.getUser_Id().equals(se)) {
	         
				
				out.println("<h1>Task List</h1>"); 
				
				
		        List<Task> list2=TaskDB.getAllTask(se);  
		        
		        out.print("<table border='1' width='auto'>");  
		        out.print("<tr><th>User id</th><th>Username</th><th>Task</th></tr>");  
		        for(Task t:list2){  
		        out.print("<tr><td>"+t.getUser_Id()+"</td><td>"+t.getName()+"</td><td>"+t.getText()+"</td></tr>");  
		        }  
		        out.print("</table>");  
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
