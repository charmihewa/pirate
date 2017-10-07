package com.pairet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pairet.util.ConnectionManager;

public class Sample {


	public static void main(String[] args) {
		
		String sql = "Select * from mydb.user_technology where tech_id='mb' OR tech_id='das'";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);


			    while (rs.next()) {
			    	System.out.println(rs.getString(1));
			    	System.out.println(rs.getString(2));
			    }

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
