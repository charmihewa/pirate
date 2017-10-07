package com.pairet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pairet.FitUser;
import com.pairet.User;


@Path("/ResourceMapper")
public class ResourceMapper {
	ArrayList<String> keywords;
	User userDao = new User();
	
	private ResourceMapperService dataService = ResourceMapperService.getInstance();
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.TEXT_PLAIN)
	public ArrayList<FitUser> createCustomer(String searchStoryDescription,String searchKeywords) {
		ArrayList<String> searchKeywordsList=new ArrayList<String>();
		searchKeywordsList.add("A");
		
		return dataService.getBestFit(searchStoryDescription, searchKeywordsList);
	}
}
