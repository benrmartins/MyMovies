package com.capstone.MyMovies.payloads.ApiResponse;

import com.capstone.MyMovies.models.WantToWatch;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WantToWatchApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private WantToWatch[] results;

    public WantToWatchApi(Long id, WantToWatch[] results) {
        this.id = id;
        this.results = results;
    }

    public WantToWatchApi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WantToWatch[] getResults() {
        return results;
    }

    public void setResults(WantToWatch[] results) {
        this.results = results;
    }
}



