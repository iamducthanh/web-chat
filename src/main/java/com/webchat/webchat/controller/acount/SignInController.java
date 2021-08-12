package com.webchat.webchat.controller.acount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/signin")
    public String signinPage(){
        return "views/acount/signin";
    }

    @GetMapping("/logoutSuccessful")
    public String signoutSuccess(){
        return "views/acount/signin";
    }
}
