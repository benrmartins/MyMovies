package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
