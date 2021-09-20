package com.webchat.webchat.controller.web;

import com.webchat.webchat.constant.AttackFile;
import com.webchat.webchat.constant.PropertiesConstant;
import com.webchat.webchat.entities.Attach;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.pojo.FilesAttack;
import com.webchat.webchat.service.impl.MessageService;
import com.webchat.webchat.service.impl.RoomDetailService;
import com.webchat.webchat.service.impl.UserService;
import com.webchat.webchat.utils.SessionUtil;
import com.webchat.webchat.utils.UploadUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
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
    private SessionUtil sessionUtil;

    @RequestMapping(value = "/message_direct", method = RequestMethod.GET)

    public String messageDirectPage(Model model) {
        String view = "redirect:/trang-chu";
        User user = (User) sessionUtil.getObject("USER");
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

    @PostMapping("/removeImage")
    @ResponseBody
    public void removeImageTemp(@RequestParam("fileName") String fileName, @RequestParam("room") String room){
        System.out.println(fileName);
        System.out.println(room);
        FilesAttack filesAttack = AttackFile.messageAttackHashMap.get(room);
        filesAttack.getFilesAttack().remove(fileName);
    }


    @PostMapping("/uploadImage")
    @ResponseBody
    public void uploadImage(@RequestPart("file") MultipartFile file, @RequestParam("roomId") String roomId) throws IOException {
        String fileName = file.getOriginalFilename();
        byte[] fileContent = file.getBytes();
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        System.out.println(encodedString);
        System.out.println(fileName);
        FilesAttack filesAttack = AttackFile.messageAttackHashMap.get(roomId);
        if(filesAttack == null){
            FilesAttack filesAttackNew = new FilesAttack();
            filesAttackNew.getFilesAttack().put(fileName, encodedString);
            AttackFile.messageAttackHashMap.put(roomId, filesAttackNew);
        } else {
            filesAttack.getFilesAttack().put(fileName, encodedString);
        }
    }

}
