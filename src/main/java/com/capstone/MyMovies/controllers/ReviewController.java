package com.capstone.MyMovies.controllers;


import com.capstone.MyMovies.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:8787")
@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private Environment env;

    @Autowired
    private Review review;

    @Autowired
    private RestTemplate restTemplate;


}
