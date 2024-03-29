package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MemberService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotEmpty;

// rest전용 컨트롤러
// 하나의 문제에 대해서 어떤건 ResponseEntity로 응답해야하고 어떤건 ModelAndView로 응답해야함
// 그래서 컨트롤러를 분리시킴 -> 꼭 이렇게 해야되나? 그건 아닌데 이렇게 하는게 좋음
// -> 이 순간부터 postman으로 검증안됨 (postman은 rest전용이기 때문에)
@RestController
public class MemberRestController {
	@Autowired
	private MemberService service;

	@ExceptionHandler(ConstraintViolationException.class) // 자바에서 클래스 이름은 ""이런 문자열 형식을 잘 안쓰고 이렇게 쓴다
	public ResponseEntity<String> CVEHandler(ConstraintViolationException e) {
		String msg = e.getConstraintViolations().stream().findFirst().get().getMessage(); // 여러 예외 중에서 제일 처음꺼 하나를 꺼내는 방식
		return ResponseEntity.status(409).body(msg);
	}

	// ResponseEntity: 응답데이터 + 상태코드
	@GetMapping("/member/id-check")
	public ResponseEntity<String> idCheck(@NotEmpty(message = "아이디는 필수입력입니다") String username) {
		Boolean result = service.idCheck(username);
		if (result == true) {
			return ResponseEntity.ok("사용가능합니다");
//			return ResponseEntity.status(200).body("사용가능합니다"); // 이거랑 똑같은 코드임
		}
		return ResponseEntity.status(409).body("사용중입니다");
	}

//	1. byte[]는 파일을 출력할 때 byte의 배열로 지정한다
//	2. @GetMapping()이 왜 복잡하냐?
//		- 어노테이션은 변형된 클래스
//		- @~Mapping 어노테이션에는 path라는 필드가 기본 필드
//		- produce 필드는 ResponseEntity에 담긴 데이터 형식을 웹 브라우저에 알려준다
	@GetMapping(path = "/profile/{image}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> viewImage(@PathVariable String image) {
		try {
			Path path = Paths.get("c:/upload/profile/" + image);
			byte[] imageBytes = Files.readAllBytes(path);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
		} catch (IOException e) {
			return ResponseEntity.notFound().build();
		}
	}

//	3. 아이디 찾기
	@GetMapping("/member/find-id")
	public ResponseEntity<String> findId(String email) {
		String username = service.findId(email);
		if (username == null) {
			return ResponseEntity.status(409).body("사용자를 찾을 수 없습니다.");
		}
		return ResponseEntity.ok(username);
	}

//	4. 비밀번호 리셋 - 비밀번호 찾기 기능은 개인정보보호법 위반
	@PostMapping("/member/reset-password")
	public ResponseEntity<String> restPassword(String username) {
		Boolean result = service.resetPassword(username);
		if (result == false) {
			return ResponseEntity.status(409).body("사용자를 찾을 수 없습니다.");
		}
		return ResponseEntity.ok("임시비밀번호를 이메일로 보냈습니다.");
	}

	// ResponseEntity<여기>에서 여기에는 객체만 올 수 있다
	// 여기에 아무 객체도 안담으려면 void형 객체 표현 Void를 사용한다
	@Secured("ROLE_USER")
	@PostMapping("/member/change-email")
	public ResponseEntity<Void> changeEmail(String email, Principal principal) {
		Boolean result = service.changeEmail(email, principal.getName());
		if (result) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.status(409).body(null);
	}
}
