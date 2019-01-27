package com.dataOne.movieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataOne.movieService.entity.User;

public interface UserRepository extends  JpaRepository<User, Long> {
	public User findUserByEmail(String email);
}
