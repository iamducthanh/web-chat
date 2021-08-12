package com.webchat.webchat.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Autowired
    HttpServletRequest req;

    @GetMapping(value = "/")
    public String homePage() {
        return "views/trangchu";
    }


//    @RequestMapping(value = "/message_empty", method = RequestMethod.GET)
//    public String messageEmptyPage() {
//        return "views/message/message-empty";
//    }
}
