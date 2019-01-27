package com.dataOne.movieService.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dataOne.movieService.entity.Movie;

public interface MovieRepository extends  JpaRepository<Movie, Long>{
	public Movie findMovieByName(String Name);
}
