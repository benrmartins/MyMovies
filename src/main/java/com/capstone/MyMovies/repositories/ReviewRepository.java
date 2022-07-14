package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
