package com.cognizant.rating.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rating.model.Rating;
import com.cognizant.rating.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	
/*	@RequestMapping("/user/{userId}")
	public List<Rating> getUserRating(@PathVariable("userId") String userId) {
		
		List<Rating>ratings = Arrays.asList(
				new Rating("1234",4),
				new Rating("5678",3)
				);
		return ratings;
		
		//this returns a list in apis. we should avoid returning list in apis
		// output =[{"movieId":"1234","rating":4},{"movieId":"5678","rating":3}]
	}

}*/
	
	
	@RequestMapping("/user/{userId}")
	public UserRating  getUserRating(@PathVariable("userId") String userId) {
		
		List<Rating>ratings = Arrays.asList(
				new Rating("1234",4),
				new Rating("5678",3)
				);
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
		//output:{"userRating":[{"movieId":"1234","rating":4},{"movieId":"5678","rating":3}]}
	}

}
