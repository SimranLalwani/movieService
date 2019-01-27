package com.dataOne.movieService.model;

import com.dataOne.movieService.entity.Movie;

public class MovieModify {
	
	private String email;	
	private Movie movie;
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public String getEmail() {
		return this.email;
	}
	public Movie getMovie() {
		return this.movie;
	}
}
