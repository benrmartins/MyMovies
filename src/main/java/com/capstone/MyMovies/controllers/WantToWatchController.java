package com.capstone.MyMovies.controllers;


import com.capstone.MyMovies.models.WantToWatch;
import com.capstone.MyMovies.payloads.ApiResponse.WantToWatchApi;
import com.capstone.MyMovies.payloads.ApiResponse.WatchedApi;
import com.capstone.MyMovies.repositories.WantToWatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:8787")
@RequestMapping("/api/wanttowatch")
public class WantToWatchController {

    @Autowired
    private Environment env;

    @Autowired
    private WantToWatch wantToWatch;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WantToWatchRepository wantToWatchRepository;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute() {
        return new ResponseEntity<>("movie Routes", HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getWantToWatch(@PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        WatchedApi response = restTemplate.getForObject(url, WatchedApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{title}")
    public ResponseEntity<?> postWantToWatch(RestTemplate restTemplate, @PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        WantToWatchApi response = restTemplate.getForObject(url, WantToWatchApi.class);

        WantToWatch wantToWatch = wantToWatchRepository.save(response.getResults()[0]);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllWantToWatch() {

        Iterable<WantToWatch> allWantToWatchApi = wantToWatchRepository.findAll();
        return ResponseEntity.ok(allWantToWatchApi);

    }

}
