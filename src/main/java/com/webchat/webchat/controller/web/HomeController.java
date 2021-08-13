package com.webchat.webchat.controller.web;

import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.service.impl.RoomDetailService;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    private RoomDetailService roomDetailService;

    @GetMapping(value = "/")
    public String beginPage() {
        return "redirect:/trang-chu";
    }

    @GetMapping(value = "/trang-chu")
    public String homePage() {
        return "views/trangchu";
    }


//    @RequestMapping(value = "/message_empty", method = RequestMethod.GET)
//    public String messageEmptyPage() {
//        return "views/message/message-empty";
//    }
}
