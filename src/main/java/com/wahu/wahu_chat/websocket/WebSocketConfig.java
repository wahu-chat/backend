package com.wahu.wahu_chat.websocket;

import com.wahu.wahu_chat.model.TutorialHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(tutorialHandler(), "/tutorial")
                .setAllowedOrigins("*");
    }

    @Bean
    WebSocketHandler tutorialHandler() {
         return new TutorialHandler();
    }


}
