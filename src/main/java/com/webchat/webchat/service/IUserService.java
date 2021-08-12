package com.webchat.webchat.service;

import com.webchat.webchat.entities.User;
import org.springframework.stereotype.Service;

public interface IUserService {
    User findByUsername(String username);
}
