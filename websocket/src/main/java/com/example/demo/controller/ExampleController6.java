package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExampleController6 {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/example6")
	public String example6() {
		return "example6";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/example6_1")
	public String example6_1() {
		return "index";
	}

	// 메모를 작성한 다음 수신자에게 메몯가 도착했다는 메세지를 보낸다
	@PostMapping("/memo")
	public void memoWrite(Memo memo, Principal principal) {
		String msg = "메모가 도착했습니다";
		System.out.println(memo);
		messagingTemplate.convertAndSendToUser(memo.getReceiver(), "/to-client/all", msg);
	}
}
