package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.payloads.ApiResponse.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
