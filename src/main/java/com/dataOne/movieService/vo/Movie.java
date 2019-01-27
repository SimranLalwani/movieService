package com.dataOne.movieService.vo;

import java.util.Date;
import java.util.List;

public class Movie {

	String name;
	String coverImageUrl;
	Date releaseDate;
	String genre;
	List<String> leadActors;
	String director;
	
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
	
	public List<String> getLeadActors() {
		return leadActors;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}
	
	public void setDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setLeadActors(List<String> leadActors) {
		this.leadActors = leadActors;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
}
