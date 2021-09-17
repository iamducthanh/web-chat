package com.webchat.webchat.service;

import com.webchat.webchat.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findInRoom(int userId, String roomId);
}
