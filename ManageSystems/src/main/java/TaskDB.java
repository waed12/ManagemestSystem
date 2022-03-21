import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class TaskDB {
	  public static Connection getConnection(){  
			Connection con = null;

			
			try {
				Class.forName("com.mysql.jdbc.Driver");
		        con=DriverManager.getConnection("jdbc:mysql://localhost/managesystems","root",""); 
				System.out.println("connected");
			    
			}catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("not connected");
			}
			return con;
	    }  
	  public static List<Task> getTask(String userId) {
		List  <Task> list=new ArrayList <Task>();
		  
		
		  try {
			Connection con=TaskDB.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select text from task where user_id='"+userId+"'");
			ResultSet result=(ResultSet) ps.executeQuery();
			while(result.next()) {
			Task task=new Task();
			task.setText(result.getString(1));	
			list.add(task);
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
	  }
	  public static int AddTask(Task task) {
		 
		int result=0;
		  try {
			
			Connection con=TaskDB.getConnection();
			PreparedStatement prepare=(PreparedStatement) con.prepareStatement("insert into task(user_id,text,state) values(?,?,?)");
			
			
		    prepare.setString(1, task.getUser_Id());
		    prepare.setString(2, task.getText());
		    prepare.setString(3, task.getState());
		    result=prepare.executeUpdate();
			

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return result;
	  }
	  public static List <Task> getAllTask() {
		 List <Task> list=new ArrayList <Task>();
		  
		
		  try {
			Connection con=TaskDB.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select task.user_id,user.name, task.text from task INNER JOIN user where task.user_id=user.user_id");
			ResultSet result=(ResultSet) ps.executeQuery();
			while(result.next()) {
			Task task=new Task();
			task.setUser_Id(result.getString(1));
			task.setName(result.getString(2));
			task.setText(result.getString(3));	
			
			list.add(task);
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
	  }
	  public static List <Task> getAllTask(String id) {
		 List <Task> list=new ArrayList <Task>();
		  
		
		  try {
			Connection con=TaskDB.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select developer.user_id,user.name,task.text from developer INNER JOIN task,user"
					+ " where developer.user_id=user.user_id and developer.user_id=task.user_id and developer.leader_id='"+id+"'");
			ResultSet result=(ResultSet) ps.executeQuery();
			while(result.next()) {
			Task task=new Task();
			task.setUser_Id(result.getString(1));
			task.setName(result.getString(2));
			task.setText(result.getString(3));	
			
			list.add(task);
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
	  }
	  public static int TaskState(Task task,String id) {
		  int result=0;
		
	        try{  
	            Connection con=TaskDB.getConnection();  
	            PreparedStatement prepare=(PreparedStatement) con.prepareStatement("update Task set state=? where user_id='"+id+"'");  
	            
	            prepare.setString(1,task.getState());  
	            
	            result=prepare.executeUpdate();  
	              
	            con.close();  
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          
	        return result;  
	    }  


}
