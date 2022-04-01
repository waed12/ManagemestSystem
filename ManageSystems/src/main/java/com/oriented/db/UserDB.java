package com.oriented.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.oriented.constant.constantInterface;
import com.oriented.user.User;

import javax.swing.*;

public class UserDB implements constantInterface {

	public static User userValidation(String userName, String password) {
		User user = null;
		try {
			if (userName.equals(null) || userName.trim().isEmpty() && password.equals(null)
					|| password.trim().isEmpty()) {

				System.out.print(enteruserNameandPassword);
			} else if (userName.equals(null) || userName.trim().isEmpty()) {
				System.out.print(enteruserName);
			} else if (password.equals(null) || password.trim().isEmpty()) {
				System.out.print(enterPassword);
			} else {
				Connection con = ConnectionDB.getConnection();
				PreparedStatement statement = (PreparedStatement) con
						.prepareStatement("select * from user where user_name=? and password=?");
				statement.setString(1, userName);
				statement.setString(2, password);
				ResultSet result = (ResultSet) statement.executeQuery();
				if (result.next()) {
					user = new User();
					user.setId(result.getString(1));
					user.setPassword(result.getString(2));
					user.setFirstName(result.getString(3));
					user.setLasttName(result.getString(4));
					user.setCity(result.getString(5));
					user.setType(result.getString(6));
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;

	}


}
