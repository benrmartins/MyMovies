package com.capstone.MyMovies.controllers;

import com.capstone.MyMovies.models.*;
import com.capstone.MyMovies.payloads.ApiResponse.WatchedApi;
import com.capstone.MyMovies.repositories.ProfileRepository;
import com.capstone.MyMovies.repositories.WatchedRepository;
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
@RequestMapping("/api/watched")
public class WatchedController {
//
    @Autowired
    private Environment env;

    @Autowired
    private WatchedRepository watchedRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileRepository profileRepository;

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

    @PostMapping("/{profileId}/{title}")
    public ResponseEntity<?> postProfileWatched(RestTemplate restTemplate, @PathVariable String title, @PathVariable Long profileId) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        User currentUser = userService.getCurrentUser();

        if(currentUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Profile profile = profileRepository.findByUser_id(currentUser.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        WatchedApi response = restTemplate.getForObject(url, WatchedApi.class);

        Watched newWatched = response.getResults()[0];

        newWatched.setProfile(profile);

        Watched watched = watchedRepository.save(newWatched);

        return new ResponseEntity<>(watched, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        watchedRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Watched> getReviewByID(@PathVariable Long id) {
        Watched watched = watchedRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return new ResponseEntity<>(watched, HttpStatus.OK);
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<Watched>> getReviewsByListener(@PathVariable Long profileId) {
        List<Watched> watched = watchedRepository.findAllByProfile_id(profileId);
        return new ResponseEntity<>(watched, HttpStatus.OK);

    }




}
