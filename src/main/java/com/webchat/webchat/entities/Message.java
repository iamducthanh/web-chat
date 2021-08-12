package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "message", uniqueConstraints = {@UniqueConstraint(columnNames = {"userId", "roomId"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "userId")
    private User user;

    @ManyToOne @JoinColumn(name = "roomId")
    private Room room;

    @Column(name = "type")
    private String type;

    @Column(name = "time")
    private Date time;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "message")
    private List<Attach> attaches;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
