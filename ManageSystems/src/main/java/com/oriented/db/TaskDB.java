package com.oriented.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.oriented.tasks.TaskBean;

public class TaskDB {

	public static List<TaskBean> getTask(String userId) {
		TaskBean task = null;
		List<TaskBean> list = new ArrayList<TaskBean>();

		try {
			Connection con = ConnectionDB.getConnection();
			PreparedStatement statement = (PreparedStatement) con
					.prepareStatement("select task_text from task where user_name=?");
			statement.setString(1, userId);
			ResultSet result = (ResultSet) statement.executeQuery();
			while (result.next()) {

				task = new TaskBean();
				task.setText(result.getString(1));
				list.add(task);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public static int EditTaskState(TaskBean task, String userName) {
		int result = 0;

		try {
			Connection con = ConnectionDB.getConnection();
			PreparedStatement statement = (PreparedStatement) con
					.prepareStatement("update Task set task_state=? where user_name=?");
			statement.setString(1, task.getState());
			statement.setString(2, userName);

			result = statement.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static int AddTask(TaskBean task) {

		int result = 0;
		try {

			Connection con = ConnectionDB.getConnection();
			PreparedStatement prepare = (PreparedStatement) con
					.prepareStatement("insert into task(user_id,text,state) values(?,?,?)");

			prepare.setString(1, task.getUser_Id());
			prepare.setString(2, task.getText());
			prepare.setString(3, "Has been sent");
			result = prepare.executeUpdate();

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static int EditTask(TaskBean task, String text, String id) {

		int result = 0;
		try {

			Connection con = ConnectionDB.getConnection();
			PreparedStatement prepare = (PreparedStatement) con
					.prepareStatement("update task set text='" + text + "', state=? where user_id='" + id + "'");

			prepare.setString(1, "Has been sent");

			result = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
