package com.webchat.webchat.model;

public class UserConnect {
    private String room;
    private String user1;
    private String user2;

    public UserConnect() {
    }

    @Override
    public String toString() {
        return "UserConnect{" +
                "room='" + room + '\'' +
                ", user1='" + user1 + '\'' +
                ", user2='" + user2 + '\'' +
                '}';
    }

    public UserConnect(String room, String user1, String user2) {
        this.room = room;
        this.user1 = user1;
        this.user2 = user2;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }
}
