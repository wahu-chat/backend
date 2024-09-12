package com.wahu.wahu_chat.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;

@Slf4j
public class TutorialHandler implements WebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connected: ", session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String msg = message.getPayload().toString();
        System.out.println(msg);
        log.info("Received: ", msg);
        session.sendMessage(new TextMessage(msg));
        //Thread.sleep(1000);
        //session.sendMessage(new TextMessage("Finished: " + session + " - " + msg));
    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("Transport error: ", exception);
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("Disconnected: ", session.getId());
    }
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
