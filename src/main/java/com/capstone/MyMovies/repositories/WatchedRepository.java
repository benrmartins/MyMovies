package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Review;
import com.capstone.MyMovies.models.Watched;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchedRepository extends JpaRepository<Watched, Long> {
    List<Watched> findAllByProfile_id(Long profile_id);


}
