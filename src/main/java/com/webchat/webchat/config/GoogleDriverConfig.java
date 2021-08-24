package com.webchat.webchat.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class GoogleDriverConfig {
//    @Autowired
//    private GoogleCredential googleCredential;
//
//    @Bean
//    public Drive getService() throws GeneralSecurityException, IOException {
//        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        return new Drive.Builder(HTTP_TRANSPORT,
//                JacksonFactory.getDefaultInstance(), googleCredential)
//                .build();
//    }
//
//    @Bean
//    public GoogleCredential googleCredential() throws GeneralSecurityException, IOException {
//        Collection<String> elenco = new ArrayList<String>();
//        elenco.add("https://www.googleapis.com/auth/drive");
//        HttpTransport httpTransport = new NetHttpTransport();
//        JacksonFactory jsonFactory = new JacksonFactory();
//        return new GoogleCredential.Builder()
//                .setTransport(httpTransport)
//                .setJsonFactory(jsonFactory)
//                .setServiceAccountId("serverdriver@iamdcuthanh.iam.gserviceaccount.com")
//                .setServiceAccountScopes(elenco)
//                .setServiceAccountPrivateKeyFromP12File(new File("C:\\Users\\ADMIN\\Downloads\\iamdcuthanh-6350072b1d4c.p12"))
//                .build();
//    }
}
