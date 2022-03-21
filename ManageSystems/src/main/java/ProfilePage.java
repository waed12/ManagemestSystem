

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
 * Servlet implementation class ProfilePage
 */
@WebServlet("/ProfilePage")
public class ProfilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePage() {
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
		manager=ManagerDB.getManager(se);
        request.setAttribute("Name", manager.getName()); 
        request.setAttribute("Id", manager.getId()); 
        request.setAttribute("City", manager.getCity());
        request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
  	     }


		List <Leader> list1=LeaderDB.getAllId();
		for(Leader leader:list1){  	 
			if(leader.getUser_Id().equals(se)) {
              leader=LeaderDB.getLeader(se);
              request.setAttribute("Name", leader.getName()); 
              request.setAttribute("Id", leader.getId()); 
              request.setAttribute("City", leader.getCity());
              request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
				break;
			}
   
		}
//Developer 
		List <Developer> list2=DeveloperDB.getAllId();
		for(Developer develop:list2){  	 
			if(develop.getUser_Id().equals(se)) {
	          develop=DeveloperDB.getDeveloper(se);
	          request.setAttribute("Name", develop.getName()); 
	          request.setAttribute("Id", develop.getId()); 
	          request.setAttribute("City", develop.getCity());
	          request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
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
