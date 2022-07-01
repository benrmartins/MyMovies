package com.capstone.MyMovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;
@Entity
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, unique = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Long id;


    @JsonProperty("results")
    @Column(name="results")
    private String[] results;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Favorites() {
    }

    public Favorites(Long id, String[] results, User user) {
        this.id = id;
        this.results = results;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getResults() {
        return results;
    }

    public void setResults(String[] results) {
        this.results = results;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":").append(id);
        sb.append(", \"results\":").append(Arrays.toString(results));
        sb.append(", \"user\":").append(user);
        sb.append('}');
        return sb.toString();
    }
}

