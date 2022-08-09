package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.models.*;
import com.capstone.MyMovies.payloads.ApiResponse.MovieApi;
import com.capstone.MyMovies.repositories.FavoriteRepository;
import com.capstone.MyMovies.repositories.ProfileRepository;
import com.capstone.MyMovies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8787", "http://localhost:3000"})
@RequestMapping("/api/favorites")
public class FavoritesController {

    @Autowired
    private Environment env;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserService userService;

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


    @PostMapping("/{profileId}/{title}")
    public ResponseEntity<?> postProfileFavorite(RestTemplate restTemplate, @PathVariable String title, @PathVariable Long profileId) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        User currentUser = userService.getCurrentUser();

        if(currentUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Profile profile = profileRepository.findByUser_id(currentUser.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        MovieApi response = restTemplate.getForObject(url, MovieApi.class);

        Favorites newFavorites = response.getResults()[0];

        newFavorites.setProfile(profile);

        Favorites favorites = favoriteRepository.save(newFavorites);

        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        favoriteRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Favorites> getFavoritesByID(@PathVariable Long id) {
        Favorites favorites = favoriteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @GetMapping("/profile/{profileId}")
    public  ResponseEntity<List<Favorites>> getFavoritesByListener(@PathVariable Long profileId) {
        List<Favorites> favorites = favoriteRepository.findAllByProfile_id(profileId);
        return new ResponseEntity<>(favorites, HttpStatus.OK);

    }



}
