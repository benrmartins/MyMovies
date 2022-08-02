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
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String favoriteGenre;




    @OneToOne
    @JoinColumn(name="users_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    @JsonIncludeProperties({"movieTitle", "body", "rating"})
    private Set<Review> reviews;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<Watched> watched;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<WantToWatch> wantToWatch;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<Favorites> favorites;

    public Profile() {
    }

    public Profile(Long id, String firstName, String lastName, Integer age, String email, String favoriteGenre) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.favoriteGenre = favoriteGenre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Review> getNotes() {
        return reviews;
    }

    public void setNotes(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Watched> getWatched() {
        return watched;
    }

    public void setWatched(Set<Watched> watched) {
        this.watched = watched;
    }

    public Set<WantToWatch> getWantToWatch() {
        return wantToWatch;
    }

    public void setWantToWatch(Set<WantToWatch> wantToWatch) {
        this.wantToWatch = wantToWatch;
    }

    public Set<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorites> favorites) {
        this.favorites = favorites;
    }
}
