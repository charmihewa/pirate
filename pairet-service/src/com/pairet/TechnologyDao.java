package com.pairet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pairet.util.ConnectionManager;

public class TechnologyDao {

	public List<Technology> getAllTechnologies() {

		List<Technology> technologyList = null;
		technologyList = new ArrayList<Technology>();
		String sql = "Select * from mydb.technology";
		try {
			Statement stmt = ConnectionManager.getConnection()
					.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Technology t2 = new Technology();
				t2.setId(rs.getString(1));
				t2.setName(rs.getString(2));

				technologyList.add(t2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return technologyList;
	}

}
