package com.webchat.webchat.component;

import com.webchat.webchat.constant.AttackFile;
import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.pojo.ChatMessagePojo;
import com.webchat.webchat.pojo.UserConnectPojo;
import com.webchat.webchat.pojo.UserOnline;
import com.webchat.webchat.utils.SystemUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.slf4j.Logger;
@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String userOnline = (String) headerAccessor.getSessionAttributes().get("userOnline");
        if(userOnline != null){
            UserOnline userOnline1 = new UserOnline();
            userOnline1.setUsername(userOnline);
            userOnline1.setType("OFFLINE");
//            int index = UsersOnline.usersOnline.indexOf(userOnline1.getUsername());
            UsersOnline.usersOnline.remove(userOnline1.getUsername());
//            UsersOnline.usersEmtityOnline.remove(index);
//            System.out.println(UsersOnline.usersEmtityOnline.size());
//            System.out.println(UsersOnline.usersOnline.size());

            messagingTemplate.convertAndSend("/topic/system.adduser", userOnline1);
        } else {
            String username = (String) headerAccessor.getSessionAttributes().get("username");
            String room = (String) headerAccessor.getSessionAttributes().get("room");
            if(username != null) {
                UserConnectPojo userConnectPojo = UsersOnline.userConnectPojo.get(room);
                if(userConnectPojo.getUser1() == null || userConnectPojo.getUser2() == null){
                    UsersOnline.userConnectPojo.remove(room);
                    AttackFile.messageAttackHashMap.remove(room);
                    System.out.println("attackkk size: "+ AttackFile.messageAttackHashMap.size());
                    System.out.println("remove");
                } else {
                    System.out.println(username);
                    if(userConnectPojo.getUser1().equals(username)){
                        userConnectPojo.setUser1(null);
                    } else if(userConnectPojo.getUser2().equals(username)){
                        userConnectPojo.setUser2(null);
                    }
                    System.out.println(userConnectPojo.toString());
                }
                logger.info("User Disconnected : " + username);
                ChatMessagePojo chatMessagePojo = new ChatMessagePojo();
                chatMessagePojo.setType(ChatMessagePojo.MessageType.LEAVE);
                chatMessagePojo.setSender(username);
                chatMessagePojo.setRoom(room);
                messagingTemplate.convertAndSend("/topic/" + room, chatMessagePojo);
            }
        }
    }

}
