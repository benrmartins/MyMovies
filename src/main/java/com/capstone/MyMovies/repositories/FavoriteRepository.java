package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorites, Long> {


}
