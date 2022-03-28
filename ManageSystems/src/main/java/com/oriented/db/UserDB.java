package com.oriented.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.oriented.user.User;

import javax.swing.*;

public class UserDB {
	public static boolean flag = false;

	public static User userValidation(String userName, String password) {
		User user = new User();
		try {

			Connection con = ConnectionDB.getConnection();
			PreparedStatement prepare = (PreparedStatement) con.prepareStatement(
					"select * from user where user_name='" + userName + "' and password='" + password + "'");
			ResultSet result = (ResultSet) prepare.executeQuery();
			if (result.next()) {
				flag = true;
				user.setId(result.getString(1));
				user.setPassword(result.getString(2));
				user.setType(result.getString(6));
			} else {
				flag = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;

	}

}
