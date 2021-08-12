package com.webchat.webchat.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class TestUtil {
    public static void main(String[] args) {
//        UUID uuid1 = UUID.randomUUID();
//        UUID uuid2 = UUID.randomUUID();
//        UUID uuid3 = UUID.randomUUID();
//        UUID uuid4 = UUID.randomUUID();
//        System.out.println(uuid1);
//        System.out.println(uuid2);
//        System.out.println(uuid3);
//        System.out.println(uuid4);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "123";
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println(encodedPassword);
    }
}
