package com.capstone.MyMovies.payloads.ApiResponse;

import javax.persistence.*;
import java.util.List;

public class MovieApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Results> results;

    public MovieApi(Long id) {
        this.id = id;
    }

    public MovieApi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}

