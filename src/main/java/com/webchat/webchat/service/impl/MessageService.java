package com.webchat.webchat.service.impl;

import com.webchat.webchat.constant.PropertiesConstant;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.Room;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.repository.MessageRepository;
import com.webchat.webchat.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Message findMessageLast(String roomId) {
        Pageable pageable = PageRequest.of(0,1);
        List<Message> list = messageRepo.findMessageLast(roomId, pageable);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int countMessageSend(String roomId, String username) {
        List<Message> list = messageRepo.countMessageSend(roomId, username);
        return list.isEmpty() ? 0 : list.size();
    }
}
