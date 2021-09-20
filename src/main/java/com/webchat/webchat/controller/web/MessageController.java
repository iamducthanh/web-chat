package com.webchat.webchat.controller.web;

import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.service.impl.MessageService;
import com.webchat.webchat.service.impl.RoomDetailService;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessageController {
    @Autowired
    private SessionUtil sessionUtil;

    @Autowired
    private RoomDetailService roomDetailService;

    @Autowired
    private HttpServletRequest req;

    @GetMapping("/message/check")
    public String checkMessage(){
        User user = (User) sessionUtil.getObject("USER");
        RoomDetail roomDetail = roomDetailService.findRoomDetailBy2User(1,2);
        System.out.println(roomDetail.getId());
        return "redirect:/trang-chu";
    }

}
