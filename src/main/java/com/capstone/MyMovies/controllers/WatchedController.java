package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.models.Review;
import com.capstone.MyMovies.models.User;
import com.capstone.MyMovies.models.Watched;
import com.capstone.MyMovies.payloads.ApiResponse.WatchedApi;
import com.capstone.MyMovies.repositories.UserRepository;
import com.capstone.MyMovies.repositories.WatchedRepository;
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
@RequestMapping("/api/watched")
public class WatchedController {

    @Autowired
    private Environment env;


    @Autowired
    private WatchedRepository watchedRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute() {
        return new ResponseEntity<>("movie Routes", HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getWatched(@PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        WatchedApi response = restTemplate.getForObject(url, WatchedApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{title}")
    public ResponseEntity<?> postWatched(RestTemplate restTemplate, @PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        WatchedApi response = restTemplate.getForObject(url, WatchedApi.class);

        Watched watched = watchedRepository.save(response.getResults()[0]);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllWatched() {

        Iterable<Watched> allMovieApi = watchedRepository.findAll();
        return ResponseEntity.ok(allMovieApi);
    }

    @PostMapping("/{userId}/{title}")
    public ResponseEntity<?> postUserWatched(RestTemplate restTemplate, @PathVariable String title, @PathVariable Long userId) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        WatchedApi response = restTemplate.getForObject(url, WatchedApi.class);

        Watched watched = watchedRepository.save(response.getResults()[0]);

        watched.setUser(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watched> getReviewByID(@PathVariable Long id) {
        Watched watched = watchedRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return new ResponseEntity<>(watched, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public  ResponseEntity<List<Watched>> getReviewsByListener(@PathVariable Long userId) {
        List<Watched> watched = watchedRepository.findAllByUser_id(userId);
        return new ResponseEntity<>(watched, HttpStatus.OK);

    }



}
