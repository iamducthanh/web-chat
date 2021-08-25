package com.webchat.webchat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "attach")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attach {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "messageid")
    private Message message;

    @Column(name = "filename")
    private String filename;

    public Attach(Message message, String filename) {
        this.message = message;
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Attach{" +
                "id=" + id +
                ", message=" + message +
                ", filename='" + filename + '\'' +
                '}';
    }
}
