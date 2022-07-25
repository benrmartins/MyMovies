package com.capstone.MyMovies.controllers;


import com.capstone.MyMovies.models.Profile;
import com.capstone.MyMovies.models.WantToWatch;
import com.capstone.MyMovies.payloads.ApiResponse.WantToWatchApi;
import com.capstone.MyMovies.payloads.ApiResponse.WatchedApi;
import com.capstone.MyMovies.repositories.ProfileRepository;
import com.capstone.MyMovies.repositories.WantToWatchRepository;
import com.capstone.MyMovies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:8787")
@RequestMapping("/api/wanttowatch")
public class WantToWatchController {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WantToWatchRepository wantToWatchRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute() {
        return new ResponseEntity<>("movie Routes", HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getWantToWatch(@PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        WantToWatchApi response = restTemplate.getForObject(url, WantToWatchApi.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{title}")
    public ResponseEntity<?> postWantToWatch(RestTemplate restTemplate, @PathVariable String title) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;

        WantToWatchApi response = restTemplate.getForObject(url, WantToWatchApi.class);

        WantToWatch wantToWatch = wantToWatchRepository.save(response.getWantToWatch()[0]);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllWantToWatch() {

        Iterable<WantToWatch> allWantToWatchApi = wantToWatchRepository.findAll();
        return ResponseEntity.ok(allWantToWatchApi);

    }
//    @PostMapping("/{profileId}/{title}")
//    public ResponseEntity<?> postProfileWantToWatch(RestTemplate restTemplate, @PathVariable String title, @PathVariable Long profileId) {
//        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + env.getProperty("AV_API_KEY") + "&query=" + title;
//
//       User currentUser = userService.getCurrentUser();
//
//        if(currentUser == null) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
//        }
//
//        Profile profile = profileRepository.findByUser_id(currentUser.getId()).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        WantToWatchApi response = restTemplate.getForObject(url, WantToWatchApi.class);
//
//        WantToWatch newWantToWatch = response.getWantToWatch()[0];
//
//        newWantToWatch.setProfile(profile);
//
//        WantToWatch wantToWatch = wantToWatchRepository.save(newWantToWatch);
//
//        return new ResponseEntity<>(wantToWatch, HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<WantToWatch> getWantToWatchByID(@PathVariable Long id) {
//        WantToWatch wantToWatch = wantToWatchRepository.findById(id).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
//        );
//        return new ResponseEntity<>(wantToWatch, HttpStatus.OK);
//    }
//
//    @GetMapping("/profile/{profileId}")
//    public  ResponseEntity<List<WantToWatch>> getWantToWatchByListener(@PathVariable Long profileId) {
//        List<WantToWatch> wantToWatch = wantToWatchRepository.findAllByProfile_id(profileId);
//        return new ResponseEntity<>(wantToWatch, HttpStatus.OK);
//
//    }



}
