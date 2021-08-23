package com.webchat.webchat.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.webchat.webchat.dto.MessagePageDto;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.pojo.MessagePojo;
import com.webchat.webchat.service.impl.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MessageApi {
    @Autowired
    private MessageService messageService;

    @GetMapping("/api/message")
    @ResponseBody
    public List<MessagePojo> getMessage(MessagePageDto messagePageDto){
        List<Message> messages = messageService.findByRoom(messagePageDto.getRoomId(), PageRequest.of(messagePageDto.getPage(), 10));
        List<MessagePojo> list = new ArrayList<>();
        if(messages != null){
            for(int i = messages.size()-1;i>-1;i--){
                list.add(new MessagePojo(messages.get(i).getId(), messages.get(i).getUser().getUsername(), messages.get(i).getContent(), messages.get(i).getTimeChat(), messages.get(i).getUser().getImage()));
            }
        }
        return list;
    }
}
