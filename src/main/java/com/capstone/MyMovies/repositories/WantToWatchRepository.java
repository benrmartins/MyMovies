package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.WantToWatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WantToWatchRepository extends JpaRepository<WantToWatch, Long> {

    List<WantToWatch> findAllByProfile_id(Long profile_id);


}
