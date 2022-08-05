package com.capstone.MyMovies.controllers;


import com.capstone.MyMovies.payloads.ApiResponse.MovieApi;
import com.capstone.MyMovies.payloads.ApiResponse.SearchApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = {"http://localhost:8787", "http://localhost:3000"})
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/test")
    public ResponseEntity<String> testRoute() {
        return new ResponseEntity<>("movie Routes", HttpStatus.OK);
    }

    @GetMapping("/upcomming")
    public ResponseEntity<?> getUpComming() {

        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=" + env.getProperty("AV_API_KEY") + "&language=en-US&page=1";

        SearchApi response = restTemplate.getForObject(url, SearchApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/toprated")
    public ResponseEntity<?> getTopRated() {

        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=" + env.getProperty("AV_API_KEY") + "&language=en-US&page=1";

        SearchApi response = restTemplate.getForObject(url, SearchApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/popular")
    public ResponseEntity<?> getPopular() {

        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + env.getProperty("AV_API_KEY") + "&language=en-US&page=1";

        SearchApi response = restTemplate.getForObject(url, SearchApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/nowplaying")
    public ResponseEntity<?> getNowPlaying() {

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + env.getProperty("AV_API_KEY") + "&language=en-US&page=1";

        SearchApi response = restTemplate.getForObject(url, SearchApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @GetMapping("/{title}")
    public ResponseEntity<?> searchByTitle(@PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        SearchApi response = restTemplate.getForObject(url, SearchApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
