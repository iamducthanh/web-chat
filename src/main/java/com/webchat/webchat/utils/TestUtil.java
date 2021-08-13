package com.webchat.webchat.utils;

import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.service.impl.RoomDetailService;
import com.webchat.webchat.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.UUID;

public class TestUtil {
    @Autowired
    static RoomDetailService roomDetailService;

    @Autowired
    static UserService userService;
    public static void main(String[] args) {
//        UUID uuid1 = UUID.randomUUID();
//        UUID uuid2 = UUID.randomUUID();
//        UUID uuid3 = UUID.randomUUID();
//        UUID uuid4 = UUID.randomUUID();
//        System.out.println(uuid1);
//        System.out.println(uuid2);
//        System.out.println(uuid3);
//        System.out.println(uuid4);
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = "123";
//        String encodedPassword = passwordEncoder.encode(password);
//        System.out.println(encodedPassword);
        System.out.println(userService.findByUsername("admin").getFirstName());
        List<RoomDetail> roomDetails = roomDetailService.findByUser(1);
        System.out.println(roomDetails.size());
    }
}
