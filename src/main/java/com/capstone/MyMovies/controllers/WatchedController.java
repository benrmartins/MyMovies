package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.models.Watched;
import com.capstone.MyMovies.payloads.ApiResponse.WatchedApi;
import com.capstone.MyMovies.repositories.WatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "http://localhost:8787")
@RequestMapping("/api/watched")
public class WatchedController {

    @Autowired
    private Environment env;

    @Autowired
    private Watched watched;

    @Autowired
    private WatchedRepository watchedRepository;
    @Autowired
    private RestTemplate restTemplate;

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


}
