package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.repositories.ProfileRepository;
import com.capstone.MyMovies.repositories.ReplyRepository;
import com.capstone.MyMovies.repositories.ReviewRepository;
import com.capstone.MyMovies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = {"http://localhost:8787", "http://localhost:3000"})
@RequestMapping("/api/reply")
public class ReplyController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ReplyRepository replyRepository;


    @GetMapping("/test")
    public ResponseEntity<?> testRoute() {
        return new ResponseEntity<>("note route", HttpStatus.OK);
    }



}
