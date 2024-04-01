package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Page;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService svc;

	@GetMapping("/")
	public ModelAndView list(@RequestParam(defaultValue = "1") Long pageno) {
		Page page = svc.findAll(pageno);
		return new ModelAndView("board/list").addObject("page", page);
	}

	@PreAuthorize("isAuthenticated()") // 관리자가 없다면 @Secured("ROLE_USER")랑 똑같음
	@GetMapping("/board/write")
	public void write() {
	}

	@Secured("ROLE_USER") // 관리자가 있다면 관리자는 글쓰기를 하면 안되니까 @Secured로 작업하는게 맞다
	@PostMapping("/board/write")
	public ModelAndView write(String content) {
		System.out.println(content);
		return null;
	}

//	@GetMapping("/board/read")
//	public void read() {
//	}
//
//	@GetMapping("/board/update")
//	public void update() {
//	}
//
//	@GetMapping("/board/delete")
//	public void delete() {
//	}

}
