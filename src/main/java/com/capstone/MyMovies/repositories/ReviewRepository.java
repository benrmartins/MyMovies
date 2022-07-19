package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByProfile_id(Long profile_id);

}
