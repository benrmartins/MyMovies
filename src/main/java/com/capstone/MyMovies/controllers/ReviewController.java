package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.models.Review;
import com.capstone.MyMovies.models.Profile;
import com.capstone.MyMovies.models.User;
import com.capstone.MyMovies.repositories.ReviewRepository;
import com.capstone.MyMovies.repositories.ProfileRepository;
import com.capstone.MyMovies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8787")
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private Environment env;
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/test")
    public ResponseEntity<?> testRoute() {
        return new ResponseEntity<>("note route", HttpStatus.OK);
    }

    @PostMapping("/{profileId}")
    public ResponseEntity<?> createReview (@RequestBody Review newReview) {

        User currentUser = userService.getCurrentUser();

        if(currentUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }



        Profile profile = profileRepository.findByUser_id(currentUser.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        newReview.setProfile(profile);

        Review review = reviewRepository.save(newReview);
        return new ResponseEntity<>(review, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<List<Review>> getAllNotes() {
        List<Review> reviews = reviewRepository.findAll();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewByID(@PathVariable Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping("profile/{profileId}")
    public  ResponseEntity<List<Review>> getReviewsByListener(@PathVariable Long profileId) {
        List<Review> reviews = reviewRepository.findAllByProfile_id(profileId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);

    }



}
