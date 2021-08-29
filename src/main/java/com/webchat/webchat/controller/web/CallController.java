package com.webchat.webchat.controller.web;

import com.webchat.webchat.pojo.CallPojo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CallController {
    @MessageMapping("/call/{username}")
    @SendTo("/topic/call/{username}")
    public CallPojo onMessage(@Payload CallPojo callDto) {
        System.out.println("call pojo");
        System.out.println(callDto.toString());
        return callDto;
    }
}
