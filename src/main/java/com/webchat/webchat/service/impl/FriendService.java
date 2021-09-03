package com.webchat.webchat.service.impl;

import com.webchat.webchat.entities.Friend;
import com.webchat.webchat.repository.FriendRepository;
import com.webchat.webchat.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService implements IFriendService {
    @Autowired
    private FriendRepository repo;

    @Override
    public List<Friend> getFriendByUser(String username) {
        List<Friend> list = repo.findByUser(username, username);
        return list.isEmpty() ? null : list;
    }
}
