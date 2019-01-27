package com.dataOne.movieService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataOne.movieService.entity.User;
import com.dataOne.movieService.model.MovieModify;
import com.dataOne.movieService.service.MovieService;


@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping("/movie")
	public User display(@RequestParam("email") String email)
	{
		return movieService.displayMovies(email);
	}
	
	@RequestMapping(value = "/movie",
			method = RequestMethod.POST)
	public User addMovie(@RequestBody MovieModify movieModify)
	{
		return movieService.addMovie(movieModify.getEmail(), movieModify.getMovie());
	}
	
	@RequestMapping(value = "/movie",
			method = RequestMethod.PUT)
	public User updateMovie(@RequestBody MovieModify movieModify)
	{
		return movieService.updateMovie(movieModify.getEmail(), movieModify.getMovie());
	}
	
	@RequestMapping(value = "/movie",
			method = RequestMethod.DELETE)
	public User updateMovie(@RequestParam("email") String email, @RequestParam("movie") String name)
	{
		return movieService.deleteMovie(email, name);
	}
}
