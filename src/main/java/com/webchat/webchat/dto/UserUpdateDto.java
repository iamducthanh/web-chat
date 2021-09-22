package com.webchat.webchat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private String username;
    private String firstName;
    private String lastname;
    private String phone;
    private Date birthday;
    private Boolean gender;
    private String description;
}
