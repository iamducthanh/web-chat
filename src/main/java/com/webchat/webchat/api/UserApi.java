package com.webchat.webchat.api;

import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.entities.Friend;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.pojo.UserPojo;
import com.webchat.webchat.service.impl.FriendService;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserApi {
    @Autowired
    private UserService userService;

    @Autowired
    private FriendService friendService;

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

}
