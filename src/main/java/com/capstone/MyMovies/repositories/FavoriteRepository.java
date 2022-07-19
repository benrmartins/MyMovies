package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Favorites;
import com.capstone.MyMovies.models.WantToWatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorites, Long> {

    List<Favorites> findAllByProfile_id(Long profile_id);


}
