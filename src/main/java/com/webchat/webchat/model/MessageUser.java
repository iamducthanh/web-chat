package com.webchat.webchat.model;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;

import java.util.Date;
import java.util.List;

public class MessageUser {
    private RoomDetail roomDetail;
    private String name;
    private List<User> users;
    private String messageLast;
    private int countMess;
    private int status;
    private Date time;
    private String roomCode;

    public MessageUser() {
    }

    public MessageUser(RoomDetail roomDetail, String name, List<User> users, String messageLast, int countMess, int status, Date time, String roomCode) {
        this.roomDetail = roomDetail;
        this.name = name;
        this.users = users;
        this.messageLast = messageLast;
        this.countMess = countMess;
        this.status = status;
        this.time = time;
        this.roomCode = roomCode;
    }

    public boolean isOnline(){
        if(UsersOnline.usersOnline.contains(this.users.get(0).getUsername())){
            return true;
        } else {
            return false;
        }
    }

    public RoomDetail getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(RoomDetail roomDetail) {
        this.roomDetail = roomDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getMessageLast() {
        return messageLast;
    }

    public void setMessageLast(String messageLast) {
        this.messageLast = messageLast;
    }

    public int getCountMess() {
        return countMess;
    }

    public void setCountMess(int countMess) {
        this.countMess = countMess;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
