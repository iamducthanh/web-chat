package com.webchat.webchat.entities;

public class User {
    private String fullname;
    private String password;

    public User(String fullname, String password) {
        this.fullname = fullname;
        this.password = password;
    }

    public User() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
