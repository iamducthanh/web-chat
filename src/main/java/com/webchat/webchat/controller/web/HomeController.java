package com.webchat.webchat.controller.web;

import com.webchat.webchat.entities.User;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Autowired
    HttpServletRequest req;

//    @RequestMapping("/")
//    public String homePage(){
//        return "views/trangchu";
//    }

    @RequestMapping("/message_group")
    public String messageGroupPage(Model model){
        User user = (User) SessionUtil.getSessionUtil().getObject(req, "USER");
        model.addAttribute("username", user.getFullname());
        return "views/message-group";
    }

//    @RequestMapping("/message_direct")
//    public String messageDirectPage(){
//        return "views/message-direct";
//    }
//
//
//    @RequestMapping("/message_empty")
//    public String messageEmptyPage(){
//        return "views/message-empty";
//    }
}
