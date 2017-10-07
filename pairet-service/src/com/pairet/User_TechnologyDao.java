package com.pairet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.pairet.util.ConnectionManager;

public class User_TechnologyDao {

	public List<User> getAllUsersForTechnology(Set<String> requiredSkills) {

		List<User> userList = null;
		String sql = "Select * from mydb.user_technology";
		if (!requiredSkills.isEmpty()) {
			sql = " where ";
			for (String skill : requiredSkills) {
				sql += "tech_id='" + skill + "'";
				Iterator<String> itr = requiredSkills.iterator();
				while(itr.hasNext()){
					sql += " OR ";
				}
			}
			

		}

		userList = new ArrayList<User>();
		try {
			Statement stmt = ConnectionManager.getConnection()
					.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				User u1 = new User();
				u1.setName(rs.getString(1));

				userList.add(u1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

}
