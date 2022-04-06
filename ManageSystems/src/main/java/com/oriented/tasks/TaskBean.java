package com.oriented.tasks;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oriented.db.TaskDB;
import com.oriented.user.User;

public class TaskBean {
	private List<TaskBean> taskList = null;
	private HttpSession session;
	private User userSession;

	private String task_id,user_id,text,state;

	public void setTask_Id(String task_id) {
		this.task_id=task_id;
	}
	public String geTask_Id() {
		return task_id;
	}
	public void setUser_Id(String user_id) {
		this.user_id=user_id;
	}
	public String getUser_Id() {
		return user_id;
	}

	public void setText(String text) {
		this.text=text;
	}
	public String getText() {
		return text;
	
}
	
	public void setState(String state) {
		this.state=state;
	}
	public String getState() {
		return state;
	
}


	public void getTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		session = request.getSession(false);
		userSession = (User) session.getAttribute("User");
		taskList = TaskDB.getTask(userSession.getId());
		if (taskList.isEmpty() || taskList == null || taskList.size() == 0) {
			out.print("<p style=text-align:center>There are no tasks for you!</p>");
		} else {
			for (TaskBean task : taskList) {
				out.println("</br>");
				out.print("<form action=EditTaskState>");
				out.print("<div style=text-align:Center>");
				out.println("<h1>Your Task is:" + task.getText() + "</h1>");
				out.println("<input type=radio name=stateradioButton value =Inprogress>InProgress");
				out.println("<input type=radio name=stateradioButton value =Done>Done");
				out.print("<tr><td colspan='2'><input type='submit' value='save '/></td></tr>");
				out.print("</div>");
				out.print("</form>");
			}

		}
	}
	

}
