package com.webchat.webchat.controller.web;

import com.webchat.webchat.entities.Room;
import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.service.impl.MessageService;
import com.webchat.webchat.service.impl.RoomDetailService;
import com.webchat.webchat.service.impl.RoomService;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class MessageController {
    @Autowired
    private SessionUtil sessionUtil;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomDetailService roomDetailService;

    @GetMapping("/message/check/{id}")
    public String checkMessage(@PathVariable("id") String id){
        User user = (User) sessionUtil.getObject("USER");
        String view = "redirect:/trang-chu";
        try {
            RoomDetail roomDetail = roomDetailService.findRoomDetailBy2User(user.getId(),Integer.parseInt(id));
            if(roomDetail != null){
                view = "redirect:/message_direct?room=" + roomDetail.getRoom().getId();
            } else {
                view = createRoomChat(id, user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public String createRoomChat(String id, User user){
        UUID roomId = UUID.randomUUID();
        Room room = new Room(String.valueOf(roomId), 0, "",user.getUsername());
        roomService.saveRoom(room);
        User user2 = new User();
        user2.setId(Integer.parseInt(id));
        List<RoomDetail> roomDetails = new ArrayList<>();
        roomDetails.add(new RoomDetail(user,room));
        roomDetails.add(new RoomDetail(user2,room));
        roomDetailService.saveRoomDetail(roomDetails);
        return "redirect:/message_direct?room=" + room.getId();
    }

}
