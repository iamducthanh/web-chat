package com.webchat.webchat.model;

public class UserOnline {
    private String username;
    private String type;

    public UserOnline() {
    }

    public UserOnline(String username, String type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
