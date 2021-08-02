package com.webchat.webchat.controller.acount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {
    @RequestMapping("/signin")
    public String signinPage(){
        return "views/acount/signin";
    }
}
