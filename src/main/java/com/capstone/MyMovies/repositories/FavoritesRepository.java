package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {

}
