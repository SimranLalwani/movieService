package com.dataOne.movieService.service;

import com.dataOne.movieService.entity.Movie;
import com.dataOne.movieService.entity.User;

public interface MovieService {

	public User displayMovies(String email);
	
	public User addMovie(String email, Movie movie);
	
	public User updateMovie(String email, Movie movie);
	
	public User deleteMovie(String email, String movieName);
}
