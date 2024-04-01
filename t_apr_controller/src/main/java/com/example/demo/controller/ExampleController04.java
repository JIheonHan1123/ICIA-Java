package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController04 {
// ResponseBody : 객체를 json으로 출력

//	MVC 방식은 프론트를 jsp가 담당(jsp는 결국 자바)
//	addAttribute()이나 addObject()로 자바객체를 보내도 다 이해한다.

//	Rest방식은 프론트를 자바스크립트가 담당(js는 자바를 이해X)
//	백이 자바 객체를 보냊면 이해가 불가능
//	웹 세계의 공용어 : JSON -> 객체를 JSON으로 변환해서 출력해야 한다.
	@GetMapping("/example4/test1")
	public @ResponseBody Product test1() {
		return new Product(1L, "맛동산", 1000L);
	}

//	인터넷에는 PC, 맥, 스파트폰 등등 서로 다른 여러기종들이 물려있다.\
//	모든 기종들이 이해할 수 있는 형식은 "문자열"
//	JSON은 객체를 문자열로 표현하는 사실상의 표준

//	ResponseEntity = @ResponseBody + 상태코드
//				   		   = Model + 작업 성공여부
	@GetMapping("/example4/test2")
	public ResponseEntity<Product> test2() {
		return ResponseEntity.ok(new Product(2L, "몽쉘", 5000L));
	}
}
