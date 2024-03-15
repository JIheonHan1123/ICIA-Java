package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.TodoDao;
import com.example.demo.entity.Todo;

// 어노테이션: @Controller, @GetMapping, @PostMapping, @RequestParam
// ModelAndView: 데이터와 화면을 담은 객체(컨트롤러의 리턴 객체)

@Controller
public class TodoController {
//		루트(/ 주소)로 들어오면 할일 목록 출력
	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list"); // list.html
		mav.addObject("todos", TodoDao.findAll());
		return mav;
	}

//		/add 주소에 Get요청이면 할 일 추가 페이지 출력
	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("add");
	}

//		/add 주소에 Post로 submit하면 할 일 저장하고 /로 redirect
	@PostMapping("/add")
	public ModelAndView add(@RequestParam String title) {
		TodoDao.save(new Todo(title));
		// ModelAndView의 주소가 redirect: 로 시작하면 이동
		return new ModelAndView("redirect:/");
	}
}
