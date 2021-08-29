package com.webchat.webchat.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.UUID;

@Component
public class UploadUtil {
    @Autowired
    ServletContext servletContext;

    public void upload(Part file) throws IOException {
        String path = servletContext.getRealPath("/files");
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File fileup = new File(dir, file.getSubmittedFileName());
        System.out.println(fileup.getAbsolutePath());
        file.write(fileup.getAbsolutePath());
    }

    public void saveFile(String dataString, String name){
        String[] strings = dataString.split(",");
        String extension;
        switch (strings[0]) {
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/gif;base64":
                extension = "gif";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default:
                extension = "jpg";
                break;
        }
        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
        String path = "D:\\Temp\\" + name + "." + extension;
        File file = new File(path);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
