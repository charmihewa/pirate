package com.pairet;

import java.util.List;

public class FitUser {
	private String userName;
	private double completionRate;
	private List<String> completedStories;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(double completionRate) {
		this.completionRate = completionRate;
	}

	public List<String> getCompletedStories() {
		return completedStories;
	}

	public void setCompletedStories(List<String> completedStories) {
		this.completedStories = completedStories;
	}

}

