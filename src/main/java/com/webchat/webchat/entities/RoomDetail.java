package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roomdetail", uniqueConstraints = {@UniqueConstraint(columnNames = {"userId", "roomId"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "userId")
    private User user;

    @ManyToOne @JoinColumn(name = "roomId")
    private Room room;
}
