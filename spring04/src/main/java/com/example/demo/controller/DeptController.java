package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.example.demo.service.*;

import jakarta.servlet.http.*;

@Controller
public class DeptController {
	@Autowired
	private DeptService service;
	
	@GetMapping("/dept/read")
	public ModelAndView read(@RequestParam Long deptno, HttpSession session) {
		if(session.getAttribute("username")==null)
			return new ModelAndView("redirect:/member/login?required");
		Map<String,Object> dept = service.read(deptno);
		return new ModelAndView("dept/read").addObject("dept", dept);
	}
}
