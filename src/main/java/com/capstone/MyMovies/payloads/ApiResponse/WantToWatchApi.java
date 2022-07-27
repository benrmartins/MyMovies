package com.capstone.MyMovies.payloads.ApiResponse;

import com.capstone.MyMovies.models.WantToWatch;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class WantToWatchApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private WantToWatch[] wantToWatch;

    public WantToWatchApi(Long id, WantToWatch[] wantToWatch) {
        this.id = id;
        this.wantToWatch = wantToWatch;
    }

    public WantToWatchApi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WantToWatch[] getWantToWatch() {
        return wantToWatch;
    }

    public void setWantToWatch(WantToWatch[] wantToWatch) {
        this.wantToWatch = wantToWatch;
    }
}
