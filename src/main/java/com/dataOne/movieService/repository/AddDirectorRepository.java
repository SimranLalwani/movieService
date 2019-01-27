package com.dataOne.movieService.repository;

import org.springframework.data.repository.CrudRepository;

import com.dataOne.movieService.entity.Director;

public interface AddDirectorRepository extends  CrudRepository<Director, Long>{
	public Director save(Director d);
}
