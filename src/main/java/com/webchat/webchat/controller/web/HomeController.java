package com.webchat.webchat.controller.web;

import com.google.api.services.drive.Drive;
import com.webchat.webchat.service.impl.RoomDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    @GetMapping(value = "/call")
    public String callvideo() {
        return "views/message/videocall";
    }



//    @RequestMapping(value = "/message_empty", method = RequestMethod.GET)
//    public String messageEmptyPage() {
//        return "views/message/message-empty";
//    }

//    public static void main(String[] args) {
//        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE, 20);
//        System.out.println(fm.format(c.getTime()));
//    }
}
