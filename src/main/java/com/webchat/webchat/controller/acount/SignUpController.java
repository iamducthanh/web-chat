package com.webchat.webchat.controller.acount;

import com.webchat.webchat.constant.CodeComfirm;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.pojo.ErrorPojo;
import com.webchat.webchat.pojo.MailPojo;
import com.webchat.webchat.pojo.UserRegisterPojo;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.MailerUtil;
import lombok.SneakyThrows;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class SignUpController {
    @Autowired
    private UserService userService;

    @Autowired
    private MailerUtil mailerUtil;

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
            } else {
                User userCheck = userService.findByUsername(user.getUsername());
                if(userCheck != null){
                    error.add(new ErrorPojo("username",message.getString("UsernameExist")));
                }
            }
        }
        String email = user.getEmail();
        if(email.indexOf("@") > 0 && email.indexOf(".") > 0 && error.size() == 0){
            User userCheck = userService.findByEmail(user.getEmail());
            if(userCheck != null){
                error.add(new ErrorPojo("email",message.getString("EmailExist")));
            }
        }
        if(!user.getCode().isBlank()){
            String code = String.valueOf(CodeComfirm.codeComfirm.get(user.getEmail()));
            if(!code.equals(user.getCode())){
                error.add(new ErrorPojo("code",message.getString("User.code")));
            }
        }
        return error;
    }

    @PostMapping("/signup/get-code")
    @ResponseBody
    public String getCode(String email) throws MessagingException {
        String out = "";
        User userCheck = userService.findByEmail(email);
        if(userCheck != null){
            out = "exist";
        } else {
            int ranNum = ThreadLocalRandom.current().nextInt(100000,999999);
            Integer code = CodeComfirm.codeComfirm.get(email);
            MailPojo mailPojo = new MailPojo();
            mailPojo.setFrom("iamducthanh01@gmail.com");
            mailPojo.setSubject("Đăng kí tài khoản");
            mailPojo.setBody("Mã xác nhận để đăng kí tài khoản của bạn là: " + ranNum);
            mailPojo.setTo(email);
            mailerUtil.send(mailPojo);
            out = "success";
            if (code != null){
                CodeComfirm.codeComfirm.remove(email);
            }
            CodeComfirm.codeComfirm.put(email,ranNum);
            Thread thread = new Thread(){
                @SneakyThrows
                @Override
                public void run() {
                    Thread.sleep(300000);
                    CodeComfirm.codeComfirm.remove(email);
                    System.out.println("size " + CodeComfirm.codeComfirm.size());
                }
            };
            thread.start();
            System.out.println("size " + CodeComfirm.codeComfirm.size());
        }
        return out;
    }
}
