package com.webchat.webchat.controller.acount;

import com.webchat.webchat.constant.CodeComfirm;
import com.webchat.webchat.pojo.ErrorPojo;
import com.webchat.webchat.pojo.UserRegisterPojo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class SignUpController {
    @GetMapping("/signup")
    public String signupPage(){
        return "views/acount/signup";
    }

    @PostMapping("/signup")
    @ResponseBody
    public List<ErrorPojo> signup(@Validated UserRegisterPojo user, BindingResult result){
        List<ErrorPojo> error = new ArrayList<>();
        ResourceBundle message = ResourceBundle.getBundle("message");
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError objectError : errors) {
                String messageError = objectError.getDefaultMessage();
                error.add(new ErrorPojo(messageError.substring(messageError.lastIndexOf(".") + 1, messageError.length()), message.getString(messageError)));
            }
        }
        if(!user.getPassword().isBlank() && !user.getComfirmPassword().isBlank()){
            if(!user.getPassword().equals(user.getComfirmPassword())){
                error.add(new ErrorPojo("comfirmPassword",message.getString("Unlike.user.comfirmPassword")));
            }
        }
        if(!user.getUsername().isBlank()){
            if(!user.getUsername().matches("[A-Za-z0-9]{5,20}")){
                error.add(new ErrorPojo("username",message.getString("specialCharacters")));
            }
        }
        return error;
    }

    @PostMapping("/signup/get-code")
    @ResponseBody
    public String getCode(String email){
        System.out.println(email);
        int ranNum = ThreadLocalRandom.current().nextInt(100000,999999);
        Integer code = CodeComfirm.codeComfirm.get(email);
        if (code != null){
            CodeComfirm.codeComfirm.remove(email);
        }
        CodeComfirm.codeComfirm.put(email,ranNum);
        System.out.println(CodeComfirm.codeComfirm.size());
        return "";
    }
}
