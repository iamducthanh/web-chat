package com.webchat.webchat.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webchat.webchat.constant.AttackFile;
import com.webchat.webchat.constant.UsersOnline;
import com.webchat.webchat.dto.FileAttackDto;
import com.webchat.webchat.dto.MessagePageDto;
import com.webchat.webchat.entities.Attach;
import com.webchat.webchat.entities.Message;
import com.webchat.webchat.entities.Room;
import com.webchat.webchat.entities.User;
import com.webchat.webchat.pojo.MessagePojo;
import com.webchat.webchat.pojo.UserConnectPojo;
import com.webchat.webchat.service.impl.AttachService;
import com.webchat.webchat.service.impl.MessageService;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
public class MessageApi {
    @Autowired
    private MessageService messageService;

    @Autowired
    private AttachService attachService;

    @Autowired
    private HttpServletRequest req;

    @GetMapping("/api/message")
    @ResponseBody
    public List<MessagePojo> getMessage(MessagePageDto messagePageDto) {
        List<Message> messages = messageService.findByRoom(messagePageDto.getRoomId(), PageRequest.of(messagePageDto.getPage(), 10));
        List<MessagePojo> list = new ArrayList<>();
        if (messages != null) {
            for (int i = messages.size() - 1; i > -1; i--) {
                List<String> listFile = null;
                if(messages.get(i).getAttachList().size() != 0){
                    listFile = new ArrayList<>();
                    for(Attach attach:messages.get(i).getAttachList()){
                        listFile.add(attach.getFilename());
                    }
                }
                list.add(new MessagePojo(messages.get(i).getId(), messages.get(i).getUser().getUsername(), messages.get(i).getContent(), messages.get(i).getTimeChat(), messages.get(i).getUser().getImage(), listFile));
            }
        }
        return list;
    }

    @PostMapping("/message_direct/save")
    @ResponseBody
    public List<FileAttackDto> saveMessage(@RequestParam("content") String content, @RequestParam("room") String roomId, @RequestParam("sendto") String sendTo, @RequestParam("attack") String attack) throws IOException {
        Message message = new Message();
        User user = (User) SessionUtil.getSessionUtil().getObject(req, "USER");
        Room room = new Room(roomId, 0, "");
        UUID uuid = UUID.randomUUID();
        message.setId(String.valueOf(uuid));
        message.setUser(user);
        message.setRoom(room);
        message.setType("CHAT");
        message.setTime(new Date());
        message.setContent(content);
        UserConnectPojo userConnectPojo = UsersOnline.userConnectPojo.get(roomId);
        if (userConnectPojo.getUser1() != null && userConnectPojo.getUser2() != null) {
            message.setStatus("READ");
        } else {
            message.setStatus("SEND");
        }
        List<FileAttackDto> dataFile = new ArrayList<>();
        List<Attach> attaches = new ArrayList<>();
        if (!attack.equals("[]")) {
            message.setType("ATTACK");
            ObjectMapper objectMapper = new ObjectMapper();
            List<String> listAttack = new ArrayList<>();
            attack = attack.replace("'", "\"");
            listAttack = Arrays.asList(objectMapper.readValue(attack, String[].class));
            for (String file : listAttack) {
                String type = file.substring(file.lastIndexOf("."), file.length());
                String id = String.valueOf(UUID.randomUUID());
                String mulFile = AttackFile.messageAttackHashMap.get(roomId).getFilesAttack().get(file);
                dataFile.add(new FileAttackDto(String.valueOf(uuid),id+type,mulFile));
                attaches.add(new Attach(message, id+type));
                AttackFile.messageAttackHashMap.get(roomId).getFilesAttack().remove(file);
                System.out.println("file attach: " + attaches.get(0).getFilename());
            }
            System.out.println("Lưu thành công");
        }
        if(dataFile.isEmpty()){
            dataFile.add(new FileAttackDto(String.valueOf(uuid),null,null));
        }
        messageService.saveMessage(message);
        if(!attack.equals("[]")){
            attachService.saveAttach(attaches);
        }
        return dataFile;
    }

    @GetMapping("/api/files")
    @ResponseBody
    public List<String> getFiles(
            @RequestParam("room") String roomId,
            @RequestParam("userInRoom") String userInRoom
            ){
        List<String> files = new ArrayList<>();
        return files;
    }
}
