package com.webchat.webchat.controller.acount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LockAcountController {
    @GetMapping("/lock_acount")
    public String lockAcountPage() {
        return "views/acount/lockacount";
    }
}
