package com.capstone.MyMovies.payloads.ApiResponse;

import javax.persistence.*;


public class MovieApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Movie[] results;

    public MovieApi(Long id, Movie[] results) {
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

    public Movie[] getResults() {
        return results;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }


}

