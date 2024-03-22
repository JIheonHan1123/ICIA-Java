package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.NewBoard;
import com.example.demo.service.NewBoardService;

// @Controller: 응답이 ModelAndView, ResponseEntity모두 가능
// @RestController: 응답이 모두 ResponseEntity
@Controller
public class NewBoardController {
	@Autowired
	private NewBoardService newBoardService;

	// 게시판 글 쓰기 -view를 보여주고, 글쓰기를 처리한다 =get하나, post하나
	@GetMapping("/newboard/write")
	public ModelAndView write() {
		return new ModelAndView("write").addObject("write");
	}

	// 게시판 글 쓰기
	// @requestParam이 너무 많으면 = 값이 여러개면 @ModelAttribute를 사용한다
	@PostMapping("/newboard/write")
	public ModelAndView write(@ModelAttribute NewBoard board) {
		System.out.println(board);
		System.out.println(newBoardService.write(board));
		return null;
	}

	// 게시판 글 목록
	@GetMapping("/newboard/find-all") // 주소에는 _잘 안쓰고 -를 씀
	public ModelAndView findAll(@RequestParam(defaultValue = "1") Long pageno) {
		return null;
	}

	// 게시판 글 읽기
	@GetMapping("/newboard/find-by-bno")
	public ModelAndView findByBno(@RequestParam Long pageno) {
		return null;
	}

	// 게시판 삭제
	// form을 submit하면 화면이 이동하면서 처리
	// $.ajax()로 보내면 화면 이동 없이 비동기처리 -> 응답(리턴값)이 ResponseEntity : Rest방식
	//
	@PostMapping("/newboard/delete")
	public ResponseEntity<Boolean> delete(@RequestParam Long bno) {
		// 스프링 rest응답 = Model + http 상태코드
		return null;
	}

}
