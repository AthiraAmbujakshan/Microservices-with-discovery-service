package com.cognizant.moviecatalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.moviecatalog.model.CatalogItem;
import com.cognizant.moviecatalog.model.Movie;
import com.cognizant.moviecatalog.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem>getCatalog(@PathVariable("userId") String userId){
		
		//calling instance of resttemplate inside the method is a bad pratise. 
		//so use beans and then autowire in the  controller class
		 
		
		//RestTemplate restTemplate = new RestTemplate();
		
		
		
		
		//get all rated movieid(here we are hardcoding
		//for each movie id, call movie-info-service and get details
		//put them together
	
		//--------------here we have hardcoded ratings------------------------------
		
	/*	List<Rating>ratings = Arrays.asList(
				new Rating("1234",4),
				new Rating("5678",3)
				);
		
		
		
		
		
		return ratings.stream().map(rating->{
			
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
		
		return new CatalogItem(movie.getName(),"Test",rating.getRating());
		}).collect(Collectors.toList()); */
		
		
		
		
		//using resttemplate to make api call
		
		//UserRating ratings = restTemplate.getForObject("http://localhost:8085/ratingsdata/user/"+userId, UserRating.class);
		
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/user/"+userId, UserRating.class);
		return ratings.getUserRating().stream().map(rating->{
			
			//Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
		
		return new CatalogItem(movie.getName(),"Test",rating.getRating());
		}).collect(Collectors.toList()); 
		
	/*	return Collections.singletonList(
	//new CatalogItem("Titanic","test", 4));*/
	}

}  




















// ---------using webclient instead of resttemplate ----------

/*	@Autowired
	private WebClient.Builder webClientBuilder;

@RequestMapping("/{userId}")
public List<CatalogItem>getCatalog(@PathVariable("userId") String userId){
	
	
	//get all rated movieid(here we are hardcoding
	//for each movie id, call movie-info-service and get details
	//put them together
	
	List<Rating>ratings = Arrays.asList(
			new Rating("1234",4),
			new Rating("5678",3)
			);
	return ratings.stream().map(rating->{
		
	Movie movie =	webClientBuilder.build()
		.get()
		.uri("http://localhost:8082/movies/\"+rating.getMovieId()")
		.retrieve()
		.bodyToMono(Movie.class)
		.block();
	
	return new CatalogItem(movie.getName(),"Test",rating.getRating());
	}).collect(Collectors.toList());
	
	
}

} */


