package com.webchat.webchat.controller.acount;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webchat.webchat.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class LockAcountController {
    @GetMapping("/lock_acount")
    public String lockAcountPage() {
        return "views/acount/lockacount";
    }

    @Autowired
    private UploadUtil uploadUtil;

    @PostMapping("/testImage")
    @ResponseBody
    public void readImage(String dataI) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> listData = Arrays.asList(objectMapper.readValue(dataI, String[].class));
        for(String data:listData){
            UUID id = UUID.randomUUID();
            String name = String.valueOf(id);
            uploadUtil.saveFile(data.toString(), name);
        }

    }
}
