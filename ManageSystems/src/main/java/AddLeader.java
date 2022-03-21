

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

/**
 * Servlet implementation class AddLeader
 */
@WebServlet("/AddLeader")
public class AddLeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLeader() {
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
		Leader leader=new Leader();
		
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pass=request.getParameter("psw");
		String city=request.getParameter("city");
		
		leader.setName(name);
		leader.setId(id);
		leader.setPassword(pass);
		leader.setCity(city);
		
		 int result=LeaderDB.AddLeader(leader); 
		 if(result>0) {
			 
			 out.print("<p>Leader Added Successfully</p>");
			 request.getRequestDispatcher("AddLeader.html").forward(request, response);	

				try {
					Connection con=LeaderDB.getConnection();
					PreparedStatement prepare;
					prepare = (PreparedStatement) con.prepareStatement("insert into leader(user_id) values(?)");
				    prepare.setString(1, leader.getId());
				    prepare.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
