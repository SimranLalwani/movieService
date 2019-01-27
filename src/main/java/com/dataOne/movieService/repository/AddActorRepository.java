package com.dataOne.movieService.repository;

import org.springframework.data.repository.CrudRepository;

import com.dataOne.movieService.entity.Actor;;

public interface AddActorRepository extends  CrudRepository<Actor, Long>{
	public Actor save(Actor actor);
}

