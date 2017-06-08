package com.github.albertocsm.ssr;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {

    registry
        .enableStompBrokerRelay("/stomp")
        .setRelayHost("localhost")
        .setRelayPort(61613)
        .setSystemHeartbeatSendInterval(20000)
        .setSystemHeartbeatReceiveInterval(20000);
    registry.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {

    registry.addEndpoint("/websocket")
            .setAllowedOrigins("*")
            .withSockJS()
            .setInterceptors(new HttpSessionHandshakeInterceptor());
  }

}
