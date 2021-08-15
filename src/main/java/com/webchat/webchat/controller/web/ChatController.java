package com.webchat.webchat.controller.web;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.model.ChatMessagePojo;
import com.webchat.webchat.model.UserConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage/{room}")
    @SendTo("/topic/{room}")
    public ChatMessagePojo sendMessage(@Payload ChatMessagePojo chatMessagePojo) {
        Date now = new Date();
        chatMessagePojo.setTimeChat(now);
        return chatMessagePojo;
    }

    @MessageMapping("/chat.addUser/{room}")
    @SendTo("/topic/{room}")
    public ChatMessagePojo addUser(@Payload ChatMessagePojo chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("da conect phong " + chatMessagePojo.getRoom());
        int index = findConnect(chatMessagePojo.getRoom());
        if(index == -1){
            UserConnect userConnect = new UserConnect(chatMessagePojo.getRoom(), chatMessagePojo.getSender(), null);
            UsersOnline.userConnect.add(userConnect);
            System.out.println(userConnect.toString());
        } else {
            if(UsersOnline.userConnect.get(index).getUser2() == null){
                UsersOnline.userConnect.get(index).setUser2(chatMessagePojo.getSender());
                System.out.println(UsersOnline.userConnect.get(index).toString());
            }
        }
        headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
        headerAccessor.getSessionAttributes().put("room", chatMessagePojo.getRoom());
        return chatMessagePojo;
    }

    public int findConnect(String room){
        for(int i = 0; i < UsersOnline.userConnect.size() ; i++){
            if(UsersOnline.userConnect.get(i).getRoom().equals(room)){
                return i;
            }
        }
        return -1;
    }
}
