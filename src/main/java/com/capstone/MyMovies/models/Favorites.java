package com.capstone.MyMovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, unique = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Long id;

    @JsonProperty("results")
    @Column(name="results", nullable = false)
    private Results[] results;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Favorites() {
    }

    public Favorites(Long id, Results[] results) {
        this.id = id;
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResults(Results[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":").append(id);
        sb.append(", \"results\":").append(results);
        sb.append('}');
        return sb.toString();
    }
}

