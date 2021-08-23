package com.webchat.webchat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessagePageDto {
    private String roomId;
    private int page;

    @Override
    public String toString() {
        return "MessagePageDto{" +
                "roomId='" + roomId + '\'' +
                ", page=" + page +
                '}';
    }
}
