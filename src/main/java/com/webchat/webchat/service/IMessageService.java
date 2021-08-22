package com.webchat.webchat.service;

import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.Room;
import com.webchat.webchat.entities.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMessageService {
    List<Message> findByRoom(String roomId, Pageable pageable);
    void saveMessage(Message message);
    void setStatusMessage(String roomId, String username, String status);
    List<Message> findByRoomAndUserAndStatus(String roomId, String username, String status);
    Message findMessageLast(String roomId);
    int countMessageSend(String roomId, String username);
}
