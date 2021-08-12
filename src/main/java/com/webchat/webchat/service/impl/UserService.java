package com.webchat.webchat.service.impl;

import com.webchat.webchat.entities.User;
import com.webchat.webchat.repository.UserRepository;
import com.webchat.webchat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepo;

    @Override
    public User findByUsername(String username) {
        List<User> list = userRepo.findUserByUsername(username);
        return list.isEmpty() ? null : list.get(0);
    }
}
