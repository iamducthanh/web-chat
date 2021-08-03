package com.webchat.webchat.controller.acount;

import com.webchat.webchat.entities.User;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController {

    @Autowired
    HttpServletRequest req;

    @RequestMapping("/signin")
    public String signinPage(Model model){
        model.addAttribute("user", new User());
        return "views/acount/signin";
    }

    @PostMapping("/signin-action")
    public String signinAction(User user){
        SessionUtil.getSessionUtil().addObject(req, "USER", user);
        return "redirect:/message_group";
    }
}
