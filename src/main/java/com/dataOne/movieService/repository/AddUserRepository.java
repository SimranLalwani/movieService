package com.dataOne.movieService.repository;

import org.springframework.data.repository.CrudRepository;

import com.dataOne.movieService.entity.User;

public interface AddUserRepository extends  CrudRepository<User, Long> {
	public User save(User user);
}
