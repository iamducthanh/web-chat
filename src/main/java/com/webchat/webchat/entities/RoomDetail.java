package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roomdetail", uniqueConstraints = {@UniqueConstraint(columnNames = {"userid", "roomid"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "userid")
    private User user;

    @ManyToOne @JoinColumn(name = "roomid")
    private Room room;
}
