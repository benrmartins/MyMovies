package com.capstone.MyMovies.payloads.ApiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

public class Results {

    private String title;
    private String poster_path;
    private String release_date;
    private Integer vote_average;
    private String original_language;
    private Integer popularity;


    public Results(String title, String poster_path, String release_date, Integer vote_average, String original_language, Integer popularity) {
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.original_language = original_language;
        this.popularity = popularity;
    }

    public Results() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Integer getVote_average() {
        return vote_average;
    }

    public void setVote_average(Integer vote_average) {
        this.vote_average = vote_average;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
}

