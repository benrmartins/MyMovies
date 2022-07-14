package com.capstone.MyMovies.payloads.ApiResponse;

import com.capstone.MyMovies.models.Watched;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class WatchedApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Watched[] watched;

    public WatchedApi(Long id, Watched[] watched) {
        this.id = id;
        this.watched = watched;
    }

    public WatchedApi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Watched[] getResults() {
        return watched;
    }

    public void setResults(Watched[] watched) {
        this.watched = watched;
    }


}

