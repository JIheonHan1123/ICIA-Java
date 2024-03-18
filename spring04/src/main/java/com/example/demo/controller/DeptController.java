package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DeptService;

import jakarta.servlet.http.HttpSession;

// DeptController: 부서정보
// EmpController: 사원목록, 사원정보, 사원추가
// LoginController: 로그인, 로그아웃

@Controller
public class DeptController {
	@Autowired
	private DeptService service;

	// 부서정보와 부서소속 사원정보 출력 0
	@GetMapping("/dept/read")
	public ModelAndView read(@RequestParam Long deptno, HttpSession session) {
		if (session.getAttribute("username") == null)
			return new ModelAndView("redirect:/member/login?required");
		Map<String, Object> dept = service.read(deptno);
		return new ModelAndView("dept/read").addObject("dept", dept);
	}
}
