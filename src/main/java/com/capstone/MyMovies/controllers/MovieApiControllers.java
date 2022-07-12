package com.capstone.MyMovies.controllers;


import com.capstone.MyMovies.payloads.ApiResponse.Movie;
import com.capstone.MyMovies.payloads.ApiResponse.MovieApi;
import com.capstone.MyMovies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:8787")
@RequestMapping("/api/favorites")
public class MovieApiControllers {

    @Autowired
    private Environment env;


    @Autowired
    private RestTemplate restTemplate;

    @Value("${myMovies.props.apiKey")
    public String apiKey;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute() {
        return new ResponseEntity<>("movie Routes", HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getFavorites(@PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        MovieApi response = restTemplate.getForObject(url, MovieApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{title}")
    public ResponseEntity<?> postFavorites(RestTemplate restTemplate, @PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" +  env.getProperty("AV_API_KEY") + "&query=" + title;

        MovieApi response = restTemplate.getForObject(url, MovieApi.class);

        Movie movie = movieRepository.save(response.getResults()[0]);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
