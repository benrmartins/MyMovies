package com.capstone.MyMovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

public class Favorites {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, unique = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    @JsonProperty("original_title")
    @Column(name="title", nullable = false)
    private String title;

    @JsonProperty("poster_path")
    @Column(name="poster", nullable = false)
    private String poster;

    @JsonProperty("budget")
    @Column(name="budget", nullable = false)
    private int budget;

    @JsonProperty("genres")
    @Column(name="genres", nullable = false)
    private String genres;

    @JsonProperty("homepage")
    @Column(name="homepage", nullable = false)
    private String homepage;

    @JsonProperty("original_language")
    @Column(name="original_language", nullable = false)
    private String originalLanguage;

    @JsonProperty("overview")
    @Column(name="overview", nullable = false)
    private String overview;

    @JsonProperty("revenue")
    @Column(name="revenue", nullable = false)
    private int revenue;

    @JsonProperty("runtime")
    @Column(name="runtime", nullable = false)
    private int runtime;

    @JsonProperty("vote_average")
    @Column(name="vote_average", nullable = false)
    private int vote;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Favorites() {
    }

    public Favorites(long id, String title, String poster, int budget, String genres, String homepage, String originalLanguage, String overview, int revenue, int runtime, int vote) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.originalLanguage = originalLanguage;
        this.overview = overview;
        this.revenue = revenue;
        this.runtime = runtime;
        this.vote = vote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":").append(id);
        sb.append(", \"title\":\"").append(title).append('"');
        sb.append(", \"poster\":\"").append(poster).append('"');
        sb.append(", \"budget\":").append(budget);
        sb.append(", \"genres\":\"").append(genres).append('"');
        sb.append(", \"homepage\":\"").append(homepage).append('"');
        sb.append(", \"originalLanguage\":\"").append(originalLanguage).append('"');
        sb.append(", \"overview\":\"").append(overview).append('"');
        sb.append(", \"revenue\":").append(revenue);
        sb.append(", \"runtime\":").append(runtime);
        sb.append(", \"vote\":").append(vote);
        sb.append('}');
        return sb.toString();
    }
}
