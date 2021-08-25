package com.webchat.webchat.service;

import com.webchat.webchat.entities.Attach;

import java.util.List;

public interface IAttachService {
    void saveAttach(List<Attach> attaches);
    List<Attach> findByMessage(String messageId);
}
