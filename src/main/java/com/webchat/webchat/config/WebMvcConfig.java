package com.webchat.webchat.config;

import com.webchat.webchat.intercepter.DataIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private DataIntercepter dataIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dataIntercepter).addPathPatterns("/trang-chu/**","/message_group/**","/message_direct/**");
    }
}
