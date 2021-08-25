package com.webchat.webchat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileAttackDto {
    private String idMessage;
    private String fileName;
    private String data;
}
