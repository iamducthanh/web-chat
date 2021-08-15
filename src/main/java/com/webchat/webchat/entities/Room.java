package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "groupchat")
    private int groupChat;

    @Column(name = "name")
    private String name;

    public Room(String id, int groupChat, String name) {
        this.id = id;
        this.groupChat = groupChat;
        this.name = name;
    }

    @OneToMany(mappedBy = "room")
    private List<Message> messages;

    @OneToMany(mappedBy = "room")
    private List<RoomDetail> roomDetails;
}
