package com.webchat.webchat.controller.acount;

import com.webchat.webchat.pojo.UserRegisterPojo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class SignUpController {
    @GetMapping("/signup")
    public String signupPage(){
        return "views/acount/signup";
    }

    @PostMapping("/signup")
    @ResponseBody
    public List<String> signup(@Validated UserRegisterPojo user, BindingResult result){
        List<String> error = new ArrayList<>();
        ResourceBundle message = ResourceBundle.getBundle("message");
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError objectError : errors) {
                error.add(message.getString(objectError.getDefaultMessage()));
                System.out.println(message.getString(objectError.getDefaultMessage()));
            }
        }
        if(!user.getPassword().isBlank() && !user.getComfirmPassword().isBlank()){
            if(!user.getPassword().equals(user.getComfirmPassword())){
                error.add(message.getString("Unlike.user.comfirmPassword"));
            }
        }
        if(!user.getUsername().isBlank()){
            if(!user.getUsername().matches("[A-Za-z0-9]{5,20}")){
                error.add(message.getString("specialCharacters"));
            }
        }
        return error;
    }

    @PostMapping("/get-code")
    @ResponseBody
    public String getCode(@RequestParam("email") String email){
        System.out.println(email);
        return "";
    }
}
