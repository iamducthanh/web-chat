package com.webchat.webchat.controller.acount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PasswordResetController {
    @GetMapping("/password_reset")
    public String passwordResetPage(){
        return "views/acount/password-reset";
    }
}
