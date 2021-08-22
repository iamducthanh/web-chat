package com.webchat.webchat.controller.web;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.pojo.ChatMessagePojo;
import com.webchat.webchat.pojo.UserConnectPojo;
import com.webchat.webchat.utils.SystemUtil;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage/{room}")
    @SendTo("/topic/{room}")
    public ChatMessagePojo sendMessage(@Payload ChatMessagePojo chatMessagePojo) {
        Date now = new Date();
        chatMessagePojo.setTimeChat(now);
        int index = SystemUtil.findConnect(chatMessagePojo.getRoom());
        if(UsersOnline.userConnectPojo.get(index).getUser1() != null && UsersOnline.userConnectPojo.get(index).getUser2() != null){
            chatMessagePojo.setStatusMessage("Đã xem");
        } else {
            chatMessagePojo.setStatusMessage("Đã gửi");
        }
        return chatMessagePojo;
    }

    @MessageMapping("/chat.addUser/{room}")
    @SendTo("/topic/{room}")
    public ChatMessagePojo addUser(@Payload ChatMessagePojo chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("da conect phong " + chatMessagePojo.getRoom());
        int index = SystemUtil.findConnect(chatMessagePojo.getRoom());
        System.out.println("index: "+index);
        if(index == -1){
            UserConnectPojo userConnectPojo = new UserConnectPojo(chatMessagePojo.getRoom(), chatMessagePojo.getSender(), null);
            UsersOnline.userConnectPojo.add(userConnectPojo);
            System.out.println(userConnectPojo.toString());
        } else {
            if(UsersOnline.userConnectPojo.get(index).getUser2() == null && UsersOnline.userConnectPojo.get(index).getUser1() != null){
                UsersOnline.userConnectPojo.get(index).setUser2(chatMessagePojo.getSender());
                System.out.println(UsersOnline.userConnectPojo.get(index).toString());
            } else if(UsersOnline.userConnectPojo.get(index).getUser2() != null && UsersOnline.userConnectPojo.get(index).getUser1() == null){
                UsersOnline.userConnectPojo.get(index).setUser1(chatMessagePojo.getSender());
                System.out.println(UsersOnline.userConnectPojo.get(index).toString());
            }
        }
        headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
        headerAccessor.getSessionAttributes().put("room", chatMessagePojo.getRoom());
        return chatMessagePojo;
    }
}
