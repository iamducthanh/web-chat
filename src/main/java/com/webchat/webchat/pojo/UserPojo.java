package com.webchat.webchat.pojo;

import com.webchat.webchat.constant.UsersOnline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPojo {
    private String username;
    private String fullName;
    private String email;
    private String image;
    private Date lastonline;
    private boolean gender;
    private String role;
    private Date birthDate;
    private String isFriend;
    private boolean online;
}
