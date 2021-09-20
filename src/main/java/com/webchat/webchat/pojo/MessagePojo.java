package com.webchat.webchat.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private List<String> listFile;

}
