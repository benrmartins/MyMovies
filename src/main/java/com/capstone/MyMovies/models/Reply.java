package com.capstone.MyMovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer likes;
    private Integer dislikes;
    private String replyMessage;


    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @JsonIncludeProperties({"firstName", "lastName", "email"})
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "review_id", referencedColumnName = "id")
    @JsonIncludeProperties({"movieTitle", "body", "rating"})
    private Review review;

    public Reply(Long id, Integer likes, Integer dislikes, String replyMessage) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
        this.replyMessage = replyMessage;
    }

    public Reply() {
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }
}
