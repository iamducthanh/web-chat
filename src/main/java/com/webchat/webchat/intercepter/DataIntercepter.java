package com.webchat.webchat.intercepter;

import com.webchat.webchat.constant.ListConstant;
import com.webchat.webchat.constant.PropertiesConstant;
import com.webchat.webchat.entities.Friend;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.pojo.MessageUser;
import com.webchat.webchat.pojo.NotificationPojo;
import com.webchat.webchat.service.impl.FriendService;
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
import java.util.Collections;
import java.util.List;

@Component
public class DataIntercepter implements HandlerInterceptor {
    @Autowired
    private RoomDetailService roomDetailService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        User user = (User) sessionUtil.getObject("USER");
        System.out.println("run");
        req.setAttribute("user", user);
        getUserOnline(req, user);
        getFriendUser(req, user);
        return true;
    }

    public void getUserOnline(HttpServletRequest req, User user) {
        req.setAttribute("userOnline", user.getUsername());
    }

    public void getMessageUser(HttpServletRequest req, User user, List<User> friends) {
        int countMessage = 0;
        List<MessageUser> messageUsers = new ArrayList<>();
        List<RoomDetail> roomDetails = roomDetailService.findByUser(user.getId());
        String name = "";
        if (roomDetails != null) {
            for (RoomDetail roomDetail : roomDetails) {
                boolean isFriend = false; // check có phải bạn bè không
                List<User> userInRoom = userService.findInRoom(user.getId(), roomDetail.getRoom().getId());
                if (userInRoom.size() == 1) {
                    name = userInRoom.get(0).getFullname();
                    isFriend = isFriend(userInRoom.get(0), friends); // check bạn bè

                } else {
                    name = roomDetail.getRoom().getName();
                }
                Message messageLast = messageService.findMessageLast(roomDetail.getRoom().getId());
                int status = 0;
                String time = "";
                int countMess = 0;
                if (messageLast != null) {
                    time = messageLast.getTimeChat();
                    countMess = messageService.countMessageSend(roomDetail.getRoom().getId(), userInRoom.get(0).getUsername());
                    if (!messageLast.getUser().getUsername().equals(user.getUsername())) {
                        if (messageLast.getStatus().equals(String.valueOf(PropertiesConstant.MessageStatus.SEND))) {
                            countMessage++;
                            status = 1;
                        }
                    }
                    if (user.getUsername().equals(messageLast.getUser().getUsername())) {
                        messageLast.setContent("Bạn: " + messageLast.getContent());
                    }
                } else {
                    messageLast = new Message();
                    messageLast.setContent("Bắt đầu trò chuyện");
                }
                boolean active = false;
                String usernameCheck = roomDetail.getRoom().getUsername();
                if (usernameCheck.equals(user.getUsername()) || usernameCheck.equals("")) {
                    active = true;
                }
                messageUsers.add(new MessageUser(roomDetail, name, userInRoom, messageLast.getContent(), countMess, status, time, roomDetail.getRoom().getId(), active, messageLast.getTime(), isFriend));
                messageUsers.sort((o1, o2) -> {
                    return o2.getTimeDate().compareTo(o1.getTimeDate());
                });
            }
        }
        req.setAttribute("messageUsers", messageUsers);
        req.setAttribute("countMessage", countMessage);
    }

    public void getFriendUser(HttpServletRequest req, User user) {
        List<User> friends = new ArrayList<>();
        List<Friend> listFriend = friendService.getFriendByUser(user.getUsername());
        List<NotificationPojo> notifications = new ArrayList<>();
        if (listFriend != null) {
            for (Friend friend : listFriend) {
                if (friend.getStatus().equals("FRIEND")) {
                    if (friend.getUser().getUsername().equals(user.getUsername())) {
                        friends.add(friend.getFriend());
                    } else {
                        friends.add(friend.getUser());
                    }
                } else if (friend.getStatus().equals("WAIT") && friend.getFriend().getUsername().equals(user.getUsername())) {
                    notifications.add(new NotificationPojo(friend.getUser(), friend.getDay()));
                }
            }
        }
        req.setAttribute("friend", friends);
        req.setAttribute("notifications", notifications);
        getMessageUser(req, user, friends);
    }

    public boolean isFriend(User user, List<User> friends) {
        for (User user1 : friends) {
            if (user1.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
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
