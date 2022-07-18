package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.models.Review;
import com.capstone.MyMovies.models.User;
import com.capstone.MyMovies.repositories.ReviewRepository;
import com.capstone.MyMovies.repositories.UserRepository;
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
    private UserRepository userRepository;

    @GetMapping("/test")
    public ResponseEntity<?> testRoute() {
        return new ResponseEntity<>("note route", HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> createReview(@PathVariable Long userId, @RequestBody Review newReview) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        newReview.setUser(user);

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

    @GetMapping("User/{userId}")
    public  ResponseEntity<List<Review>> getReviewsByListener(@PathVariable Long userId) {
        List<Review> reviews = reviewRepository.findAllByUser_id(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);

    }



}
