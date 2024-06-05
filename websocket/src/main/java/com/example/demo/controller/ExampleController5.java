package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController5 {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	// 화면
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/example5")
	public String example5() {
		return "example5";
	}

	// 일반채팅
	// 채팅메시지 -> 보낸사람아이디 + 채팅메시지 => 발송
	@MessageMapping("/chat5")
	@SendTo("/to-client/chat5")
	public String chat5(String message, Principal principal) {
		return principal.getName() + ":" + message;
	}

	// 귓속말: 받을사람아이디 + 채팅메시지
	// 1. 클라이언트에서 {'opponent':아이디, 'message':메시지} 형식으로 JSON 메시지를 서버로 전송
	// 2. 서버는 @Payload 어노테이션으로 json으로 받아서 자바객체 WhisperMessage로 변환
	// 3. 특정사용자에게 전송하는 어노테이션은 없다
	// -> @sendToUser: 자신이 본낸 메시지를 자신이 수신하는 어노테이션
	// -> templates로 전송
	@MessageMapping("/whisper")
	public void whisper(@Payload WhisperMessage message, Principal principal) {
		String msg = principal.getName() + ":" + message.getMessage();
		messagingTemplate.convertAndSendToUser(message.getOpponent(), "/to-client/whisper", msg);
	}
}
