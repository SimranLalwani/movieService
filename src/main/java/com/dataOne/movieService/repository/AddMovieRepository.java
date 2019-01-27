package com.dataOne.movieService.repository;

import org.springframework.data.repository.CrudRepository;

import com.dataOne.movieService.entity.Movie;

public interface AddMovieRepository extends  CrudRepository<Movie, Long>{
	public Movie save(Movie Movie);
}
