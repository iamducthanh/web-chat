package com.webchat.webchat.pojo;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public boolean isOnline(){
        if(UsersOnline.usersOnline.get(this.users.get(0).getUsername()) != null){
            return true;
        } else {
            return false;
        }
    }
}
