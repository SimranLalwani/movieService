package com.dataOne.movieService.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class User {

	@Column
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String password;

	@Column
	private Timestamp joiningTime;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_movie", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "movie_id") })
	private Set<Movie> movies;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setJoiningTime(Timestamp joiningTime) {
		this.joiningTime = joiningTime;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Timestamp getJoiningTime() {
		return this.joiningTime;
	}
	
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	public Set<Movie> getMovies()
	{
		return this.movies;
	}
}
