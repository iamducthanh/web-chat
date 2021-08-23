package com.webchat.webchat.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessagePojo {
    private String id;
    private String sender;
    private String content;
    private String time;
    private String image;
}
