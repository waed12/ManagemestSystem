package com.oriented.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionDB {

	private static BasicDataSource ds = new BasicDataSource();;

	public static Connection getConnection() throws SQLException {

		return ds.getConnection();

	}

	public ConnectionDB(String url, String driver, String username, String password) {
		try {

			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setMinIdle(5);
			ds.setMaxIdle(10);
			ds.setMaxOpenPreparedStatements(100);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("not connected");
		}
	}

}
