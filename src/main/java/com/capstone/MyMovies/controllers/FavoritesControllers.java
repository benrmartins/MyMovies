package com.capstone.MyMovies.controllers;


import com.capstone.MyMovies.models.Favorites;
import com.capstone.MyMovies.repositories.FavoritesRepository;
import com.capstone.MyMovies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesControllers {

    @Autowired
    private Environment env;

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private UserRepository userRepository;

    private final String BASE_URL = "https://api.themoviedb.org/3/search/movie?api_key=";

    @GetMapping("/{title}")
    public ResponseEntity<?> findMovie(RestTemplate restTemplate, @PathVariable String title) {
        String url = BASE_URL + env.getProperty("AV-API-KEY") + "&query=" + title;
        System.out.println(url);
        Favorites favorite = restTemplate.getForObject(url, Favorites.class);
        return ResponseEntity.ok(favorite);

    }

}
