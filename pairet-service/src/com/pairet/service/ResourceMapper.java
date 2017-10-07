package com.pairet.service;

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

@Path("/UserService")
public class ResourceMapper {
	ArrayList<String> keywords;
	UserDao userDao = new UserDao();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}


}
