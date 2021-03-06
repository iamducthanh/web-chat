package com.webchat.webchat.controller.web;

import com.webchat.webchat.entities.User;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessageGroupController {
    @Autowired
    private SessionUtil sessionUtil;

    @RequestMapping(value = "/message_group", method = RequestMethod.GET)
    public String messageGroupPage(Model model) {
        User user = (User) sessionUtil.getObject("USER");
        model.addAttribute("username", user.getUsername());
        return "views/message/message-group";
    }
}
