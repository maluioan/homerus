package com.test.jpa.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.jpa.entity.Movie;
import com.test.jpa.repository.IMovieRepository;

@RestController
public class RestServiceController {

	private static final Logger logger = LogManager
			.getLogger(RestServiceController.class);

	@Autowired
	private IMovieRepository repo;

	@RequestMapping("/")
//	@ResponseBody
	public String test() {
		return "some test here";
	}
	
	@RequestMapping("movies/create")
	@ResponseBody
	public String createMovie(String title, int year) {
		try {
			repo.save(new Movie(title, year));
		} catch (Exception e) {
			logger.error("Error creating", e);
		}
		return "movie created: " + title + " in year: " + year;
	}

	// READ
	@RequestMapping("/movies/read")
	@ResponseBody
	public String readMovie(long id) {
		Movie movie;
		try {
			movie = repo.findOne(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return e.getMessage();
		}
		if (movie == null) {
			String errorMst = "no movie found for id " + id;
			logger.error(errorMst);
			return errorMst;
		} else {
			return movie.getTitle() + " : " + movie.getYear();
		}
	}

	// UPDATE
	@RequestMapping("/movies/update")
	@ResponseBody
	public String readMovie(long id, String title, int year) {
		Movie movie;
		try {
			movie = repo.findOne(id);
			movie.setTitle(title);
			movie.setYear(year);
			repo.save(movie);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return e.getMessage();
		}
		return movie.getTitle() + " : " + movie.getYear();
	}

	// DELETE
	@RequestMapping("/movies/delete")
	@ResponseBody
	public String deleteMovie(long id) {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return e.getMessage();
		}
		return "deletion successful";
	}

	@RequestMapping("/movies/readAllBeforeYear")
	public List<Movie> getMoviesBeforeYear(@RequestParam(value = "year") int year) {
		List<Movie> movies = repo.findByYearLessThan(year);
		return movies;
	}
}
