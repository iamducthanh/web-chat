package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "attach", uniqueConstraints = {@UniqueConstraint(columnNames = {"messageId"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne @JoinColumn(name = "messageId")
    private Message message;

    @Column(name = "filename")
    private String filename;
}
