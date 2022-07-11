package com.capstone.MyMovies.controllers;


import com.capstone.MyMovies.payloads.ApiResponse.MovieApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesControllers {
//
    @Autowired
    private RestTemplate restTemplate;
    @Value("${myMovies.props.apiKey")
    public String apiKey;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute() {
        return new ResponseEntity<>("movie Routes", HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getFavorites(@PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + "d6277369e412f84f7c1eb673062ab1a5" + "&query=" + title;

        MovieApi response = restTemplate.getForObject(url, MovieApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
