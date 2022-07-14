package com.capstone.MyMovies.controllers;


import com.capstone.MyMovies.models.Favorites;
import com.capstone.MyMovies.payloads.ApiResponse.MovieApi;
import com.capstone.MyMovies.repositories.FavoriteRepository;
import com.capstone.MyMovies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:8787")
@RequestMapping("/api/favorites")
public class FavoritesController {

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FavoriteRepository favoriteRepository;

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
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        MovieApi response = restTemplate.getForObject(url, MovieApi.class);


        Favorites favorites = favoriteRepository.save(response.getResults()[0]);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllFavorites() {

        Iterable<Favorites> allMovieApi = favoriteRepository.findAll();
        return ResponseEntity.ok(allMovieApi);

    }




}
