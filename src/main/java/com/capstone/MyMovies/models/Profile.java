package com.capstone.MyMovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    @JsonIncludeProperties({"movieTitle", "body", "rating"})
    private Set<Review> notes;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<Watched> watched;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<WantToWatch> wantToWatch;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<Favorites> favorites;

    public Profile() {
    }

    public Profile(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Set<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorites> favorites) {
        this.favorites = favorites;
    }

    public Set<WantToWatch> getWantToWatch() {
        return wantToWatch;
    }

    public void setWantToWatch(Set<WantToWatch> wantToWatch) {
        this.wantToWatch = wantToWatch;
    }

    public Set<Review> getNotes() {
        return notes;
    }

    public void setNotes(Set<Review> notes) {
        this.notes = notes;
    }

    public Set<Watched> getWatched() {
        return watched;
    }

    public void setWatched(Set<Watched> watched) {
        this.watched = watched;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
