package com.dataOne.movieService.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movie {

	@Column
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String coverImageUrl;
	
	@Column
	private Date releaseDate;
	
	@Column
	private String genre;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movie_actor", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	private Set<Actor> actors;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="director_id")
	private Director director;
	
	
	
	public String getName() {
		return name;
	}
	
	public String getCoverImageUrl() {
		return coverImageUrl;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}
	
	public Director getDirector() {
		return director;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
	public void setDirector(Director director) {
		this.director = director;
	}
}
