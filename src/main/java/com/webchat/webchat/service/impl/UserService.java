package com.webchat.webchat.service.impl;

import com.webchat.webchat.entities.User;
import com.webchat.webchat.repository.UserRepository;
import com.webchat.webchat.service.IUserService;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public User findByUsername(String username) {
        List<User> list = userRepo.findUserByUsername(username);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public User findById(Integer id) {
        List<User> list = userRepo.findUserById(id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        List<User> list = userRepo.findUserByUsernameAndPassword(username, password);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public User findByEmail(String email) {
        List<User> list = userRepo.findUserByEmail(email);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> findInRoom(int userId, String roomId) {
        List<User> list = userRepo.findUserInRoom(userId, roomId);
        return list.isEmpty() ? null : list;
    }

    @Override
    public List<User> findByKeyword(String username, String email) {
        username = "%" + username + "%";
        email = "%" + email + "%";
        User user = (User) sessionUtil.getObject("USER");
        System.out.println(user.getUsername());
        List<User> list = userRepo.findUserByKeyword(username, email, user.getUsername(), PageRequest.of(0, 30));
        return list.isEmpty() ? null : list;
    }
}
