package com.webchat.webchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS(); // cái này để SockJS gọi đến
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { //config cho message broker
        registry.setApplicationDestinationPrefixes("/app"); // đặt tiền tố gửi từ client lên server
        registry.enableSimpleBroker("/topic"); // đặt tiền tố gửi lại các messages từ server về client
    }
}
