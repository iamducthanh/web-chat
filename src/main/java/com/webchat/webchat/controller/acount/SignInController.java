package com.webchat.webchat.controller.acount;

import com.webchat.webchat.entities.User;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.CookieUtil;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SignInController implements UserDetailsService {
    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private UserService userService;

    @Autowired
    HttpServletRequest req;

    User user = null;

    @GetMapping("/signin")
    public String signinPage(Model model){
        String view = "views/acount/signin";
//        String username = cookieUtil.get("username");
//        String password = cookieUtil.get("password");
//        System.out.println(username);
//        System.out.println(password);
//        if(username != null && password != null){
//            System.out.println("bat dau tim");
//            user = userService.findByUsernameAndPassword(username, password);
//            if(user != null){
//                System.out.println("tim thay user");
//                loadUserByUsername(username);
//                view = "redirect:/trang-chu";
//            }
//        }
        return view;
    }

    @GetMapping("/logoutSuccessful")
    public String signoutSuccess(){
        return "views/acount/signin";
    }

    @PostMapping("/signin/remember")
    @ResponseBody
    public String rememberSignin(
            @RequestParam("username") String username,
            @RequestParam("password") String password
            ){
        BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
        String passwordEncoded = pass.encode(password);
        int hour = 60 * 60 * 24 * 10;
        cookieUtil.add("username",username, hour);
        cookieUtil.add("password",passwordEncoded, hour);
        return "";
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<String> roleNames = new ArrayList<>();
        roleNames.add(user.getRole());
        SessionUtil.getSessionUtil().addObject(req, "USER", user);
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
