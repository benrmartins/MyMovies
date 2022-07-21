package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUser_id(Long id);
}
