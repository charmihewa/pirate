package com.pairet;

import java.util.List;

public class FitUser {
	private User user;
	private double completionRate;
	private List<String> completedStories;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

