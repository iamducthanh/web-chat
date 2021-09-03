package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "friend", uniqueConstraints = {@UniqueConstraint(columnNames = {"userId", "friendId"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "userid")
    private User user;

    @ManyToOne @JoinColumn(name = "friendid")
    private User friend;

    @Column(name = "day")
    private Date day;

    @Column(name = "status")
    private String status;
}
