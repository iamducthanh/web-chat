package com.webchat.webchat.service.impl;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.utils.CookieUtil;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUsername(userName);

        if (user == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        String usernameCookie = cookieUtil.get("username");
        String passwordCookie = cookieUtil.get("password");
        if(usernameCookie != null && usernameCookie.equals(user.getUsername()) && passwordCookie != null){
            int hour = 60 * 60 * 24 * 10;
            cookieUtil.add("remember","on", hour);
        } else {
            cookieUtil.add("remember","on", 0);
        }
        sessionUtil.addObject("USER", user);
//        UsersOnline.usersEmtityOnline.add(user);
        System.out.println("Found User: " + user);

        List<String> roleNames = new ArrayList<>();
        roleNames.add(user.getRole());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantList);
        return userDetails;
    }

}
