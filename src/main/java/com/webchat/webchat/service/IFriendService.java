package com.webchat.webchat.service;

import com.webchat.webchat.entities.Friend;

import java.util.List;

public interface IFriendService {
    List<Friend> getFriendByUser(String username);
}
