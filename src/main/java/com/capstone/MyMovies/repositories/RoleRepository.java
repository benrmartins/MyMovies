package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.ERole;
import com.capstone.MyMovies.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
