package com.capstone.MyMovies.payloads.response;

public class MessageResponse {
    private String message;


    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
