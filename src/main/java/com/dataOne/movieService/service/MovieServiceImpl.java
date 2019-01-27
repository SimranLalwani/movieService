package com.dataOne.movieService.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataOne.movieService.entity.Actor;
import com.dataOne.movieService.entity.Director;
import com.dataOne.movieService.entity.Movie;
import com.dataOne.movieService.entity.User;
import com.dataOne.movieService.repository.ActorRepository;
import com.dataOne.movieService.repository.AddActorRepository;
import com.dataOne.movieService.repository.AddDirectorRepository;
import com.dataOne.movieService.repository.AddMovieRepository;
import com.dataOne.movieService.repository.AddUserRepository;
import com.dataOne.movieService.repository.DirectorRepository;
import com.dataOne.movieService.repository.MovieRepository;
import com.dataOne.movieService.repository.UserRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AddUserRepository addUserRepo;
	
	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	AddMovieRepository addMovieRepo;
	
	@Autowired
	DirectorRepository directorRepo;
	
	@Autowired
	ActorRepository actorRepo;
	
	@Autowired
	AddActorRepository addActorRepo;
	
	@Autowired
	AddDirectorRepository AddDirectorRepo;
	
	public User displayMovies(String email)
	{
		User user = userRepo.findUserByEmail(email);	
		return user;
	}
	

	public User addMovie(String email, Movie movie){
		
		User user = displayMovies(email);
		
		Movie m = movieRepo.findMovieByName(movie.getName());
		if(m == null)
		{
			Set<Actor> actors = new HashSet<Actor>();
			for (Actor ac : movie.getActors())
			{
				Actor ch = actorRepo.findActorByName(ac.getName());
				if(ch == null)
					ch = addActorRepo.save(ac);
				actors.add(ch);	
			}
			
			movie.setActors(actors);
			
			Director d = directorRepo.findDirectorByName(movie.getDirector().getName());
			if(d == null)		
				d =	AddDirectorRepo.save(movie.getDirector());
			movie.setDirector(d);
				
			m = addMovieRepo.save(movie);
		}
		Set<Movie> movies = user.getMovies();
		movies.add(m);
		user.setMovies(movies);
		User updatedUser = addUserRepo.save(user);
		return updatedUser;
	}
	
	public User updateMovie(String email, Movie movie) {
		Movie m = movieRepo.findMovieByName(movie.getName());
		if(m == null)
			return addMovie(email, movie);
		else {
			m.setCoverImageUrl(movie.getCoverImageUrl());
			m.setReleaseDate(movie.getReleaseDate());
			m.setGenre(movie.getGenre());
			
			Set<Actor> actors = new HashSet<Actor>();
			for (Actor ac : movie.getActors())
			{
				Actor ch = actorRepo.findActorByName(ac.getName());
				if(ch == null)
					ch = addActorRepo.save(ac);
				actors.add(ch);	
			}
			
			m.setActors(actors);
			
			Director d = directorRepo.findDirectorByName(movie.getDirector().getName());
			if(d == null)		
				d =	AddDirectorRepo.save(movie.getDirector());
			m.setDirector(d);
	
		Movie updatedMovie = addMovieRepo.save(m);
		return displayMovies(email);
		}
	}
	
	public User deleteMovie(String email, String movieName) {
		User user = displayMovies(email);
		Movie m = movieRepo.findMovieByName(movieName);
		Set<Movie> movies = user.getMovies();
		movies.remove(m);
		user.setMovies(movies);
		User updatedUser = addUserRepo.save(user);
		return updatedUser;
	}
}
