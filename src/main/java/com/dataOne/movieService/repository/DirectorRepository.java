package com.dataOne.movieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataOne.movieService.entity.Director;

public interface DirectorRepository extends  JpaRepository<Director, Long>{
	public Director findDirectorByName(String name);
}
