package com.webchat.webchat.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.webchat.webchat.constant.UsersOnline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "image")
    private String image;

    @Column(name = "lastonline")
    private Date lastonline;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "role")
    private String role;

    @Column(name = "birthdate")
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;

    @OneToMany(mappedBy = "user")
    private List<Friend> users;

    @OneToMany(mappedBy = "friend")
    private List<Friend> friends;

    @OneToMany(mappedBy = "user")
    private List<RoomDetail> roomDetails;

    public boolean isOnline(){
        if(UsersOnline.usersOnline.get(this.username) != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", role='" + role + '\'' +
                '}';
    }

    public String getFullname(){
        return this.lastName + " " + this.firstName;
    }
}
