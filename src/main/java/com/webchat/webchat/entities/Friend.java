package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public String getTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(this.day);
        return strDate;
    }
}
