package com.webchat.webchat.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("")
    public String homePage(){
        return "views/trangchu";
    }

    @RequestMapping("/message_group")
    public String messageGroupPage(){
        return "views/message-group";
    }

    @RequestMapping("/message_direct")
    public String messageDirectPage(){
        return "views/message-direct";
    }


    @RequestMapping("/message_empty")
    public String messageEmptyPage(){
        return "views/message-empty";
    }
}
