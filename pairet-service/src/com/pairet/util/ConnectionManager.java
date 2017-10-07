package com.pairet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static String url = "hacked2017db.cobmwj5ayput.us-east-1.rds.amazonaws.com";
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
				// log an exception. fro example:
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			// log an exception. for example:
			System.out.println("Driver not found.");
		}
		return con;
	}
}