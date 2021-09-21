package com.webchat.webchat.controller.web;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.pojo.MessageUserConnectPojo;
import com.webchat.webchat.pojo.MessageUserRealtime;
import com.webchat.webchat.pojo.UserOnline;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SystemController {

    @MessageMapping("/system.adduser")
    @SendTo("/topic/system.adduser")
    public UserOnline addUser(@Payload UserOnline userOnline, SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("da online " + userOnline.getUsername());
        UsersOnline.usersOnline.put(userOnline.getUsername(), userOnline.getUsername());
        headerAccessor.getSessionAttributes().put("userOnline", userOnline.getUsername());
        return userOnline;
    }

    @MessageMapping("/system.onmessage/{username}")
    @SendTo("/topic/system.onmessage/{username}")
    public MessageUserRealtime onMessage(@Payload MessageUserRealtime messageUserRealtime) {
        System.out.println(messageUserRealtime.toString());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(new Date());
        messageUserRealtime.setTime(strDate);
        return messageUserRealtime;
    }

    @MessageMapping("/system/{username}")
    @SendTo("/topic/system/{username}")
    public MessageUserConnectPojo onMessage(@Payload MessageUserConnectPojo messageUserConnectPojo) {
        System.out.println(messageUserConnectPojo.toString());
        return messageUserConnectPojo;
    }
}
