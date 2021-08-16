package com.webchat.webchat.service;

import com.webchat.webchat.entities.Message;

import java.util.List;

public interface IMessageService {
    List<Message> findByRoom(String roomId);
    void saveMessage(Message message);
}
