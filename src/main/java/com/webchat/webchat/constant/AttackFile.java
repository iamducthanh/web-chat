package com.webchat.webchat.constant;

import com.webchat.webchat.pojo.FilesAttack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

public class AttackFile {
    public static HashMap<String, FilesAttack> messageAttackHashMap = new HashMap<>();
}
