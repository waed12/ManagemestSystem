

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

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		
		String username=request.getParameter("uname");
		String password=request.getParameter("psw");
		Connection con = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        con=DriverManager.getConnection("jdbc:mysql://localhost/managesystems","root",""); 
			//out.println("connected");
	        Statement stm=(Statement) con.createStatement();
	        ResultSet result=(ResultSet) stm.executeQuery("select * from user where User_id='"+username+"' and Password='"+password+"'");
	        if(result.next()) {
	        	//out.print("success");
	        	// login manager
	    		Manager manager=ManagerDB.getId();
	    			            //out.println(manager.getId());	 
			      if(manager.getId().equals(username)) {
		         	HttpSession session=request.getSession();
		                	session.setAttribute("user", username);
		                	request.getRequestDispatcher("HomeServ").forward(request, response);
		                	
			            }
			          
		            
		    	List <Leader> list1=LeaderDB.getAllId();
		    	 	for(Leader leader:list1){  
				            //out.println(leader.getId());	 
				          if(leader.getUser_Id().equals(username)) {
			                	HttpSession session=request.getSession();
			                	session.setAttribute("user", username);
			                	request.getRequestDispatcher("HomeServ").forward(request, response);
			                	break;
				            }
				           
			           }
		    	//Developer 
			   List <Developer> list2=DeveloperDB.getAllId();
		    	 	for(Developer develop:list2){  
				           // out.println(develop.getUser_Id());	 
				          if(develop.getUser_Id().equals(username)) {
			                	HttpSession session=request.getSession();
			                	session.setAttribute("user", username);
			                	request.getRequestDispatcher("HomeServ").forward(request, response);
			                	break;
				            }
				           
			           }
		    	

          
            } else {
	        	out.print("User name or password are error");
	        	request.getRequestDispatcher("Login.html").include(request, response);
	        }
	        
			
		
		}catch(Exception e) {
			out.println(e.getMessage());
			out.println("not connected");
		}
	}

}
