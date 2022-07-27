package com.capstone.MyMovies.payloads.ApiResponse;

import com.capstone.MyMovies.models.Favorites;

import javax.persistence.*;


public class MovieApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Favorites[] results;

    public MovieApi(Long id, Favorites[] results) {
        this.id = id;
        this.results = results;
    }

    public MovieApi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Favorites[] getResults() {
        return results;
    }

    public void setResults(Favorites[] results) {
        this.results = results;
    }


}

