package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
