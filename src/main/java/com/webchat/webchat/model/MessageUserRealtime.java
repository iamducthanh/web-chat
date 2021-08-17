package com.webchat.webchat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageUserRealtime {
    private String sender;
    private String reader;
    private String content;
    private String time;

    @Override
    public String toString() {
        return "MessageUserRealtime{" +
                "sender='" + sender + '\'' +
                ", reader='" + reader + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
