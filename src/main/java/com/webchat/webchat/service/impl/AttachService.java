package com.webchat.webchat.service.impl;

import com.webchat.webchat.entities.Attach;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.repository.AttachRepository;
import com.webchat.webchat.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachService implements IAttachService {
    @Autowired
    private AttachRepository repo;

    @Override
    public void saveAttach(List<Attach> attaches) {
        repo.saveAll(attaches);
    }

    @Override
    public List<Attach> findByMessage(String messageId) {
        List<Attach> list = repo.findByMessage(messageId);
        return list.isEmpty() ? null : list;
    }

    @Override
    public List<Attach> findByRoom(String roomId) {
        List<Attach> list = repo.findByRoom(roomId);
        return list.isEmpty() ? null : list;
    }
}
