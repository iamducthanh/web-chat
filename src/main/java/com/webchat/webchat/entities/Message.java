package com.webchat.webchat.entities;

import com.webchat.webchat.service.impl.AttachService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "message", uniqueConstraints = {@UniqueConstraint(columnNames = {"userid", "roomid"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @Column(name = "id")
    private String id;

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

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "message")
    private List<Attach> attachList;

    public Message(User user, Room room, String type, Date time, String content, String status) {
        this.user = user;
        this.room = room;
        this.type = type;
        this.time = time;
        this.content = content;
        this.status = status;
    }

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
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String strDate = dateFormat.format(this.time);
        return strDate;
    }
}
