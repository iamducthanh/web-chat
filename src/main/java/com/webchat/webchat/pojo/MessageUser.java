package com.webchat.webchat.pojo;

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
    private String time;
    private String roomCode;
    private boolean active;
    private Date timeDate;
    private boolean isFriend;

    public MessageUser() {
    }

    public MessageUser(RoomDetail roomDetail, String name, List<User> users, String messageLast, int countMess, int status, String time, String roomCode, boolean active,Date timeDate) {
        this.roomDetail = roomDetail;
        this.name = name;
        this.users = users;
        this.messageLast = messageLast;
        this.countMess = countMess;
        this.status = status;
        this.time = time;
        this.roomCode = roomCode;
        this.active = active;
        this.timeDate = timeDate;
    }

    public MessageUser(RoomDetail roomDetail, String name, List<User> users, String messageLast, int countMess, int status, String time, String roomCode) {
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
        if(UsersOnline.usersOnline.get(this.users.get(0).getUsername()) != null){
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }
}
