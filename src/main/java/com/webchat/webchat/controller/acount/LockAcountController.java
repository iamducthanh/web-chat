package com.webchat.webchat.controller.acount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LockAcountController {

    @RequestMapping("/lock_acount")
    public String lockAcountPage(){
        return "views/acount/lockacount";
    }
}
