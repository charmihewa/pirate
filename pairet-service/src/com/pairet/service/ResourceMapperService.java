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
import com.pairet.Technology;
import com.pairet.TechnologyDao;
import com.pairet.User;
import com.pairet.FitUser;
import com.pairet.UserDao;
import com.pairet.User_TechnologyDao;
import com.pairet.util.ConnectionManager;

public class ResourceMapperService {

	ArrayList<String> keywords;

    private static ResourceMapperService instance = new ResourceMapperService();

    public static ResourceMapperService getInstance() {
        return instance;
    }
    
	public ArrayList<FitUser> getBestFit(String searchStoryDescription,
			ArrayList<String> searchKeywords) {

		ArrayList<FitUser> fitUserList =new ArrayList<FitUser>();

		Set<String> requiredSkills = new TreeSet<String>();

		for (Technology technology : getKeywords()) {
			if (searchStoryDescription.contains(technology.getName())) {
				requiredSkills.add(technology.getName());
			}
		}

		for (String keyword : searchKeywords) {
			requiredSkills.add(keyword);
		}

		// search the users for requiredSkills in DB
		for (User user : new User_TechnologyDao().getAllUsersForTechnology(requiredSkills)) {
			FitUser fitUser =new FitUser();
			fitUser.setUser(user);
			fitUser.setCompletionRate(10.0);
			// Return the user list with compitancy level
			fitUserList.add(fitUser);
		}


		return fitUserList;
	}
	
	public static void main(String[] args) {
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("mb");
		arrayList.add("das");
		for (FitUser fitUser : getInstance().getBestFit("Create mb que for ABC and show in das", arrayList)) {
			System.out.println(fitUser.getUser().getName());
		}
	}

	private ArrayList<Technology> getKeywords() {
		return (ArrayList<Technology>) new TechnologyDao().getAllTechnologies();
	}

}
