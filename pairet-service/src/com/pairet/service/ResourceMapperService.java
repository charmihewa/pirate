package com.pairet.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pairet.FitUser;
import com.pairet.User;
import com.pairet.UserDao;
import com.pairet.FitUser;
import com.pairet.util.ConnectionManager;

public class ResourceMapperService {
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	ArrayList<String> keywords;

	private ArrayList<FitUser> mappingLogic(String searchStoryDescription,
			ArrayList<String> searchKeywords) {

		ArrayList<FitUser> fitUserList;

		Set<String> requiredSkills = new TreeSet<String>();

		for (String keyword : getKeywords()) {
			if (searchStoryDescription.contains(keyword)) {
				requiredSkills.add(keyword);
			}
		}

		for (String keyword : searchKeywords) {
			requiredSkills.add(keyword);
		}

		// search the users for requiredSkills in DB
		
		String sql="";
		con = ConnectionManager.getConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// Return the user list with compitancy level
		fitUserList = new ArrayList<FitUser>();

		return fitUserList;
	}

	public ArrayList<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(ArrayList<String> keywords) {
		if (this.keywords != null) {
			for (String keyword : keywords) {
				this.keywords.add(keyword);
			}

		} else {
			this.keywords = keywords;
		}
	}
}
