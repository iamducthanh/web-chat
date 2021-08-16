package com.webchat.webchat.service.impl;

import com.webchat.webchat.constant.PropertiesConstant;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.Room;
import com.webchat.webchat.entities.User;
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

    @Override
    public void saveMessage(Message message) {
        messageRepo.save(message);
    }

    @Override
    public void setStatusMessage(String roomId, String username, String status) {
        List<Message> list = messageRepo.findByRoomAndUserAndStatus(roomId, username, status);
        if(list != null){
            for(Message message : list){
                message.setStatus(String.valueOf(PropertiesConstant.MessageStatus.READ));
            }
            messageRepo.saveAll(list);
        }
    }

    @Override
    public List<Message> findByRoomAndUserAndStatus(String roomId, String username, String status) {
        List<Message> list = messageRepo.findByRoomAndUserAndStatus(roomId, username, status);
        for(Message message : list){
            message.setStatus(String.valueOf(PropertiesConstant.MessageStatus.READ));
        }
        return list.isEmpty() ? null : list;
    }
}
