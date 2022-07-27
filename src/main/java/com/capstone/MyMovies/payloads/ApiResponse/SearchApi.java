package com.capstone.MyMovies.payloads.ApiResponse;

import com.capstone.MyMovies.models.Favorites;
import com.capstone.MyMovies.models.Search;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class SearchApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Search[] results;

    public SearchApi(Long id, Search[] results) {
        this.id = id;
        this.results = results;
    }

    public SearchApi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Search[] getResults() {
        return results;
    }

    public void setResults(Search[] results) {
        this.results = results;
    }


}

