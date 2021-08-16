package com.webchat.webchat.controller.web;

import com.webchat.webchat.constant.PropertiesConstant;
import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.Room;
import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.model.ChatMessagePojo;
import com.webchat.webchat.service.impl.MessageService;
import com.webchat.webchat.service.impl.RoomDetailService;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.SessionUtil;
import com.webchat.webchat.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

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
                List<Message> messages = messageService.findByRoom(roomId);
                if(messages != null){
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
        message.setUser(user);
        message.setRoom(room);
        message.setType("CHAT");
        message.setTime(new Date());
        message.setContent(content);
        int index = SystemUtil.findConnect(roomId);
        if(UsersOnline.userConnect.get(index).getUser1() != null && UsersOnline.userConnect.get(index).getUser2() != null){
            message.setStatus("READ");
        } else {
            message.setStatus("SEND");
        }
        messageService.saveMessage(message);
    }
}
