package com.webchat.webchat.service.impl;

import com.webchat.webchat.entities.Message;
import com.webchat.webchat.repository.MessageRepository;
import com.webchat.webchat.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {
    @Autowired
    private MessageRepository messageRepo;

    @Override
    public List<Message> findByRoom(String roomId) {
        List<Message> list = messageRepo.findByRoom(roomId);
        return list.isEmpty() ? null : list;
    }
}
