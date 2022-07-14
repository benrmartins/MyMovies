package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.WantToWatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WantToWatchRepository extends JpaRepository<WantToWatch, Long> {

}
