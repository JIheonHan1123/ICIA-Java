package com.example.demo.controller1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

//irum : spring, nai : 20을 서버로 넘긴다면 
//1. 넘기는 형식 
//1.1 urlencoded : irum=spring&nai=20
//1.2 form-data : 파일까지 전송할 수 있다.
//1.3 json : {'irum':'spring', 'nai':'20'} -> @RequestBody

//2. urlencoded값이 주소창에 나타나는가?
//2.1 get방식일때 주소창에 ?irum=spring&nai=20 -> querystring
//2.2 post방식일때는 나타나지 않는다. 

//입력 데이터에서 값을 꺼내는 어노테이션
//@RequestParam : /find?irum=spring          String irum

//@PathVariable :    /find/spring            String irum
//         @GetMapping("/find/{irum}")

//@ModelAttribute   : ?irum=spring&nai=20      여러값을 담은 객체 

@Slf4j
@Controller
public class ExampleController11 {
	@GetMapping("/example11/start")
	public void start() {
	}

	@PostMapping("/example11/test1")
	public ModelAndView test1(@ModelAttribute Product product) {
		log.info("{}", product);
		return null;
	}

	@PostMapping("/example11/test2")
	public ResponseEntity<Product> test2(@ModelAttribute Product product) {
		log.info("{}", product);
		// return ResponseEntity.ok(product);
		return ResponseEntity.status(409).body(product);
	}
}
