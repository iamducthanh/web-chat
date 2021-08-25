package com.webchat.webchat.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

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
}
