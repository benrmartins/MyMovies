package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Watched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchedRepository extends JpaRepository<Watched, Long> {
}
