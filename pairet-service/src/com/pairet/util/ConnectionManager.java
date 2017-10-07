package com.pairet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static String url = "jdbc:mysql://hacked2017db.cobmwj5ayput.us-east-1.rds.amazonaws.com:3306/mydb";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "hacked_pirate";
	private static String password = "pirate123";
	private static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {

				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {

			System.out.println("Driver not found.");
		}
		return con;
	}
}