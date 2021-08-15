package com.webchat.webchat.controller.web;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.model.ChatMessagePojo;
import com.webchat.webchat.model.UserOnline;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class SystemController {

    @MessageMapping("/system.adduser")
    @SendTo("/topic/system.adduser")
    public UserOnline addUser(@Payload UserOnline userOnline, SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("da online");
        UsersOnline.usersOnline.add(userOnline.getUsername());
        headerAccessor.getSessionAttributes().put("userOnline", userOnline.getUsername());
        return userOnline;
    }
}
