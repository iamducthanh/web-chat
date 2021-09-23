package com.webchat.webchat.api;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.dto.ChangePasswordDto;
import com.webchat.webchat.dto.UserProfileUpdateDto;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.pojo.ErrorPojo;
import com.webchat.webchat.pojo.UserPojo;
import com.webchat.webchat.service.impl.FriendService;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserApi {
    @Autowired
    private UserService userService;

    @Autowired
    private SessionUtil sessionUtil;

    @PostMapping("/user/search")
    @ResponseBody
    public List<UserPojo> getUserByKeyword(@RequestParam("keyword") String keyword) {
        List<UserPojo> userPojos = new ArrayList<>();
        User myUser = (User) sessionUtil.getObject("USER");
        if (!keyword.isBlank()) {
            List<User> users = userService.findByKeyword(keyword, keyword);
            if(users != null){
                for (User user : users) {
                    String isFriend = "";
//                    Friend friend = friendService.getFriendByUser();
                    userPojos.add(new UserPojo(
                            user.getId(),
                            user.getUsername(),
                            user.getFullname(),
                            user.getEmail(),
                            user.getImage(),
                            user.getLastonline(),
                            user.isGender(),
                            user.getRole(),
                            user.getBirthDate(),
                            isFriend,
                            UsersOnline.usersOnline.get(user.getUsername()) != null ? true : false
                    ));
                }
            }
        }
        return userPojos;

    }

    @PutMapping("/user/update/image")
    @ResponseBody
    public String updateUser(@RequestParam("image") String image){
        User user = (User) sessionUtil.getObject("USER");
        user.setImage(image);
        userService.saveUser(user);
        return "done";
    }

    public static void main(String[] args) {
        final String uri = "http://localhost:8080/user/search";
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-COM-PERSIST", "NO");
        headers.set("X-COM-LOCATION", "USA");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<UserPojo> responseEntity = restTemplate
                .exchange(uri, HttpMethod.GET, entity, UserPojo.class);
//        System.out.println(responseEntity.getBody().getData());
    }

    @PutMapping("/user/update/profile")
    @ResponseBody
    public List<ErrorPojo> updateProfile(@Validated UserProfileUpdateDto userProfileUpdateDto, BindingResult result){
        User user = (User) sessionUtil.getObject("USER");
        List<ErrorPojo> error = new ArrayList<>();
        ResourceBundle message = ResourceBundle.getBundle("message");
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError objectError : errors) {
                String messageError = objectError.getDefaultMessage();
                error.add(new ErrorPojo(messageError.substring(messageError.lastIndexOf(".") + 1, messageError.length()), message.getString(messageError)));
            }
        }
        if(!userProfileUpdateDto.getUsername().isBlank()){
            if(!userProfileUpdateDto.getUsername().matches("[A-Za-z0-9]{5,20}")){
                error.add(new ErrorPojo("username",message.getString("specialCharacters")));
            } else {
                if(!user.getUsername().equals(userProfileUpdateDto.getUsername())){
                    User userCheck = userService.findByUsername(userProfileUpdateDto.getUsername());
                    if(userCheck != null){
                        error.add(new ErrorPojo("username",message.getString("UsernameExist")));
                    }
                }
            }
        }
        if(!userProfileUpdateDto.getPhone().isBlank()){
            if(!userProfileUpdateDto.getPhone().matches("[0]{1}[0-9]{9}")){
                error.add(new ErrorPojo("phone",message.getString("User.phone")));
            }
        }
        if(userProfileUpdateDto.getDescription().length() > 100){
            error.add(new ErrorPojo("description",message.getString("User.description")));
        }
        if(!String.valueOf(user.getId()).equals(userProfileUpdateDto.getId())){
            error.add(new ErrorPojo("id",message.getString("User.id")));
        }
        if(error.size() == 0){
            saveUpdateUserProfile(user, userProfileUpdateDto);
        }
        return error;
    }

    public void saveUpdateUserProfile(User user, UserProfileUpdateDto userProfileUpdateDto){
        user.setPhone(userProfileUpdateDto.getPhone());
        user.setUsername(userProfileUpdateDto.getUsername());
        user.setDescription(userProfileUpdateDto.getDescription());
        user.setFirstName(userProfileUpdateDto.getFirstName());
        user.setLastName(userProfileUpdateDto.getLastName());
        user.setGender(userProfileUpdateDto.getGender());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthDate = sdf.parse(userProfileUpdateDto.getBirthday());
            user.setBirthDate(birthDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.saveUser(user);
    }

    @PutMapping("/user/change_password")
    @ResponseBody
    public List<ErrorPojo> changePassword(@Validated ChangePasswordDto changePasswordDto, BindingResult result){
        List<ErrorPojo> error = new ArrayList<>();
        User user = (User) sessionUtil.getObject("USER");
        ResourceBundle message = ResourceBundle.getBundle("message");
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError objectError : errors) {
                String messageError = objectError.getDefaultMessage();
                error.add(new ErrorPojo(messageError.substring(messageError.lastIndexOf(".") + 1, messageError.length()), message.getString(messageError)));
            }
        }
        String password = changePasswordDto.getPassword();
        BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
        if(!changePasswordDto.getPassword().isBlank()){
            if(!pass.matches(password, user.getPassword())){
                error.add(new ErrorPojo("password",message.getString("User.password")));
            }
        }
        if(error.isEmpty()){
            user.setPassword(pass.encode(changePasswordDto.getNewPassword()));
            userService.saveUser(user);
        }
        return error;
    }

}
