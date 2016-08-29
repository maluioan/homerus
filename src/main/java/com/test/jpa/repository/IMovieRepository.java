package com.test.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.jpa.entity.Movie;

public interface IMovieRepository extends CrudRepository<Movie, Long> {

	List<Movie> findByYearLessThan(int year);

}
