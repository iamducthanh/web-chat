package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String fullname;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
