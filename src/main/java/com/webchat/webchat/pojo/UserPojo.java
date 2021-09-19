package com.webchat.webchat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
}
