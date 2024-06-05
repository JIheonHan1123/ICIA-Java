package com.example.demo;

import org.springframework.context.annotation.*;
import org.springframework.messaging.simp.config.*;
import org.springframework.web.socket.config.annotation.*;

// 웹소켓 라이브러리 : stomp
// 사용자가 웹소켓에 연결할 주소 : /connect
// 사용자가 웹소켓에 메시지를 전송할 prefix : /to-server로 시작한다
// 사용자가 웹소켓에 메시지를 수신할 prefix : /to-client로 시작한다
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/connect").setAllowedOriginPatterns("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/to-client");
		registry.setApplicationDestinationPrefixes("/to-server");
	}
}
