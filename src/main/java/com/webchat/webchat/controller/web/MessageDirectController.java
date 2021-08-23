package com.webchat.webchat.controller.web;

import com.webchat.webchat.constant.PropertiesConstant;
import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.Room;
import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.pojo.UserConnectPojo;
import com.webchat.webchat.service.impl.MessageService;
import com.webchat.webchat.service.impl.RoomDetailService;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.SessionUtil;
import com.webchat.webchat.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class MessageDirectController {
    @Autowired
    private HttpServletRequest req;

    @Autowired
    private RoomDetailService roomDetailService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletResponse resp;

    @RequestMapping(value = "/message_direct", method = RequestMethod.GET)
    public String messageDirectPage(Model model) {
        String view = "redirect:/trang-chu";
        User user = (User) SessionUtil.getSessionUtil().getObject(req, "USER");
        model.addAttribute("username", user.getUsername());
        String roomId = req.getParameter("room");
        if(roomId != null){
            RoomDetail roomDetail = roomDetailService.findRoomDetailByUserAndRoom(user.getId(), roomId);
            if(roomDetail != null){
                view = "views/message/message-direct";
                List<User> userInRoom = userService.findInRoom(user.getId(), roomId);
                model.addAttribute("userInRoom", userInRoom.get(0));
                List<Message> messages = messageService.findByRoom(roomId, PageRequest.of(0, 10));
                if(messages != null){
                    Collections.reverse(messages);
                    messageService.setStatusMessage(roomId, userInRoom.get(0).getUsername(), String.valueOf(PropertiesConstant.MessageStatus.SEND));
                    String userLastMessage = messages.get(messages.size()-1).getUser().getUsername();
                    if(userLastMessage.equals(user.getUsername())){
                        if(messages.get(messages.size()-1).getStatus().equals(String.valueOf(PropertiesConstant.MessageStatus.SEND))){
                            req.setAttribute("statusMessage","Đã gửi");
                        } else {
                            req.setAttribute("statusMessage","Đã xem");
                        }
                    }
                }
                model.addAttribute("messages", messages);
            }
        }
        model.addAttribute("room", roomId);
        return view;
    }

    @PostMapping("/message_direct/save")
    @ResponseBody
    public void saveMessage(@RequestParam("content") String content, @RequestParam("room") String roomId, @RequestParam("sendto") String sendTo) {
        Message message = new Message();
        User user = (User) SessionUtil.getSessionUtil().getObject(req, "USER");
        Room room = new Room(roomId,0,"");
        UUID uuid = UUID.randomUUID();
        message.setId(String.valueOf(uuid));
        message.setUser(user);
        message.setRoom(room);
        message.setType("CHAT");
        message.setTime(new Date());
        message.setContent(content);
        UserConnectPojo userConnectPojo = UsersOnline.userConnectPojo.get(roomId);
        if(userConnectPojo.getUser1() != null && userConnectPojo.getUser2() != null){
            message.setStatus("READ");
        } else {
            message.setStatus("SEND");
        }
        messageService.saveMessage(message);
    }


    @Autowired
    HttpServletRequest httpServletRequest;
    @PostMapping("/uploadImage")
    @ResponseBody
    public void uploadImage(@RequestPart("file") MultipartFile file){
        System.out.println(file.getSize());
        System.out.println("okkkkkkkkkkkkkkk");
    }
}
