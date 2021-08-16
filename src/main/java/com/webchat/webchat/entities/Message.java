package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "message", uniqueConstraints = {@UniqueConstraint(columnNames = {"userid", "roomid"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "userid")
    private User user;

    @ManyToOne @JoinColumn(name = "roomid")
    private Room room;

    @Column(name = "type")
    private String type;

    @Column(name = "time")
    private Date time;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "message")
    private List<Attach> attaches;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user=" + user.getUsername() +
                ", room=" + room.getId() +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getTimeChat(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(this.time);
        return strDate;
    }
}
