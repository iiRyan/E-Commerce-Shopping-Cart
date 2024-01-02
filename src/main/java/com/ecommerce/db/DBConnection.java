package com.ecommerce.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	private static Connection connection = null;

	public static Connection getConnection() {

		try {
			String dbURL = "jdbc:mysql://localhost:3306/ecommerce_cart";
			String userName = "root";
			String password = "password1";

			// Load JDBC Driver
			Class.forName("com.mysql.jdbc.Driver"); // MySql Driver Class Name.

			// open Connection to MySql ecommerce_cart DB.
			connection = DriverManager.getConnection(dbURL, userName, password);

			// Condition to make sure connection is established.
			if (connection != null) {
				System.out.println("Connected Succecfully!");
			} else {
				System.out.println("Failed to Connect!");
			}
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	public static void main(String[] args) {
		DBConnection.getConnection();
	}

}
