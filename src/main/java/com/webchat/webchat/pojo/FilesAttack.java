package com.webchat.webchat.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.util.HashMap;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilesAttack {
    HashMap<String, String> filesAttack = new HashMap<>();
}
