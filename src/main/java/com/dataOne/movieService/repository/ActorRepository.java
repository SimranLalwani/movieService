package com.dataOne.movieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataOne.movieService.entity.Actor;;

public interface ActorRepository extends  JpaRepository<Actor, Long>{
	public Actor findActorByName(String name);
}

