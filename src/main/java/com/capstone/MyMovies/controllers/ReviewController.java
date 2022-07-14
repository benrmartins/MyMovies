package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.models.Review;
import com.capstone.MyMovies.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


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


}
