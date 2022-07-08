package com.cognizant.moviecatalog.model;

import java.util.List;
// to avoid return list   we are creating this model class
public class UserRating {

	private List<Rating> userRating;

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
	
}
