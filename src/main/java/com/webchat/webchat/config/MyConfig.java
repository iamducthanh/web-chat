package com.webchat.webchat.config;

import com.webchat.webchat.filter.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public FilterRegistrationBean<AuthorizationFilter> loggingFilter(){
        FilterRegistrationBean<AuthorizationFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthorizationFilter());
        registrationBean.addUrlPatterns("/message_group/*");
        return registrationBean;
    }
}
