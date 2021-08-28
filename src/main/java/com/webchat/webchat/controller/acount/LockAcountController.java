package com.webchat.webchat.controller.acount;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webchat.webchat.dto.ImageDto;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class LockAcountController {
    @GetMapping("/lock_acount")
    public String lockAcountPage() {
        return "views/acount/lockacount";
    }

    @PostMapping("/testImage")
    @ResponseBody
    public void readImage(String dataI) throws JsonProcessingException {
        System.out.println("dataa: "+dataI);
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> listData = Arrays.asList(objectMapper.readValue(dataI, String[].class));
        System.out.println(listData.size());
    }
}
