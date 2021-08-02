package com.webchat.webchat.component;

import com.webchat.webchat.model.ChatMessagePojo;
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
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        String room = (String) headerAccessor.getSessionAttributes().get("room");
        if(username != null) {
            logger.info("User Disconnected : " + username);
            ChatMessagePojo chatMessagePojo = new ChatMessagePojo();
            chatMessagePojo.setType(ChatMessagePojo.MessageType.LEAVE);
            chatMessagePojo.setSender(username);
            chatMessagePojo.setRoom(room);
            messagingTemplate.convertAndSend("/topic/" + room, chatMessagePojo);
        }
    }
}
