package com.cognizant.movieinfo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movieinfo.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId)
	{
		return new Movie(movieId, "pulimurughan");
	}

}
