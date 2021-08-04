package com.webchat.webchat.controller.web;

import com.webchat.webchat.model.ChatMessagePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {
//    @Autowired
//    HttpServletRequest req;

//    @RequestMapping("/chat")
//    public String index(Model model){
//        String room = req.getParameter("room");
//        model.addAttribute("room",room);
//        return "test";
//    }

    @MessageMapping("/chat.sendMessage/{room}")
    @SendTo("/topic/{room}")
    public ChatMessagePojo sendMessage(@Payload ChatMessagePojo chatMessagePojo) {
        Date now = new Date();
        chatMessagePojo.setTimeChat(now);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date date = new Date();
        String dateFormat = formatter.format(date);
        return chatMessagePojo;
    }

    @MessageMapping("/chat.addUser/{room}")
    @SendTo("/topic/{room}")
    public ChatMessagePojo addUser(@Payload ChatMessagePojo chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("da conect");
        headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
        headerAccessor.getSessionAttributes().put("room", chatMessagePojo.getRoom());
        return chatMessagePojo;
    }
}
