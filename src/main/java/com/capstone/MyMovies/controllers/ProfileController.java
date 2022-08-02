package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.models.Profile;
import com.capstone.MyMovies.models.User;
import com.capstone.MyMovies.repositories.FavoriteRepository;
import com.capstone.MyMovies.repositories.ProfileRepository;
import com.capstone.MyMovies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8787", "http://localhost:3000"})
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseEntity<?> testRoute() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile newProfile) {

        User currentUser = userService.getCurrentUser();

        if(currentUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        newProfile.setUser(currentUser);

        Profile profile = profileRepository.save(newProfile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }


}
