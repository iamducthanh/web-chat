package com.webchat.webchat.intercepter;

import com.webchat.webchat.constant.PropertiesConstant;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.model.MessageUser;
import com.webchat.webchat.service.impl.MessageService;
import com.webchat.webchat.service.impl.RoomDetailService;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataIntercepter implements HandlerInterceptor {
    @Autowired
    private RoomDetailService roomDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String uri = req.getRequestURI();
        User user = (User) SessionUtil.getSessionUtil().getObject(req, "USER");
        System.out.println("run");
        List<MessageUser> messageUsers = new ArrayList<>();
        List<RoomDetail> roomDetails = roomDetailService.findByUser(user.getId());
        String name = "";
        for(RoomDetail roomDetail : roomDetails){
            List<User> userInRoom = userService.findInRoom(user.getId(), roomDetail.getRoom().getId());
            if(userInRoom.size() == 1){
                name = userInRoom.get(0).getFullname();
            } else {
                name = roomDetail.getRoom().getName();
            }
            Message messageLast = messageService.findMessageLast(roomDetail.getRoom().getId());
            int status = 0;
            String time = "";
            int countMess = 0;
            if(messageLast != null){
                time = messageLast.getTimeChat();
                countMess = messageService.countMessageSend(roomDetail.getRoom().getId(), userInRoom.get(0).getUsername());
                if(!messageLast.getUser().getUsername().equals(user.getUsername())){
                    if(messageLast.getStatus().equals(String.valueOf(PropertiesConstant.MessageStatus.SEND))){
                        status = 1;
                    }
                }
                if(user.getUsername().equals(messageLast.getUser().getUsername())){
                    messageLast.setContent("Bạn: " + messageLast.getContent());
                }
            } else {
                messageLast = new Message();
                messageLast.setContent("Bắt đầu trò chuyện");
            }
            messageUsers.add(new MessageUser(roomDetail, name, userInRoom, messageLast.getContent(), countMess, status, time, roomDetail.getRoom().getId()));
        }
        req.setAttribute("user", user);
        req.setAttribute("userOnline", user.getUsername());
        req.setAttribute("messageUsers", messageUsers);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
