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
public class MessageDirectController {
    @Autowired
    private HttpServletRequest req;

    @RequestMapping(value = "/message_direct", method = RequestMethod.GET)
    public String messageDirectPage(Model model) {
        User user = (User) SessionUtil.getSessionUtil().getObject(req, "USER");
        model.addAttribute("username", user.getUsername());
        return "views/message/message-direct";
    }
}
