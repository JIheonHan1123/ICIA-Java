package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Emp;
import com.example.demo.service.EmpService;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Validated
@Controller
public class EmpController {
	@Autowired
	private EmpService service;

	// 가입할 때 필요한 정보들을 저장: mgrs, deptnos, jobs
	// 서버를 키면 처음에 읽어오자
	private Map<String, Object> addInfo;

	// 스프링의 초기화 메소드를 지정하는 어노테이션
	// 스프링빈의 생성자는 스프링이 사용한다(개발자는 어노테이션을 사용한다)
	// 객체가 태어나서 죽는 것을 생명주기 혹은 수명주기(life cycle)라고 한다
	// 서블릿의 생명주기: init() -> service() -> destroy()
	// 스프링빈의 생명주기: @postConstruct -> ??? -> @PreDestroy
	@PostConstruct
	public void init() {
		addInfo = service.findAddInfo();
	}

	// 사원 목록
	// url을 여러개 걸려면 배열을 사용한다
	@GetMapping({ "/", "/emp/list" })
	public ModelAndView list() {
		List<Emp> list = service.list();
		return new ModelAndView("emp/list").addObject("list", list);
	}

	// 사원 상세
	@GetMapping("/emp/read")
	public ModelAndView read(@RequestParam Long empno, HttpSession session) {
		if (session.getAttribute("username") == null)
			return new ModelAndView("redirect:/member/login?required");
		Emp emp = service.read(empno);
		return new ModelAndView("emp/read").addObject("emp", emp);
	}

	// 사원 추가
	@GetMapping("/emp/add")
	public ModelAndView add(HttpSession session) {
		if (session.getAttribute("username") == null)
			return new ModelAndView("/redirect:/member/login?required");
		return new ModelAndView("emp/add").addObject("addInfo", addInfo);
	}

	@PostMapping("/emp/add")
	public ModelAndView add(@ModelAttribute @Valid Emp emp, BindingResult bindingResult, HttpSession session) {
		if (session.getAttribute("username") == null)
			return new ModelAndView("redirect:/member/login?required");
		service.add(emp);
		return new ModelAndView("redirect:/");
	}

	// 사원 삭제
	@PostMapping("/emp/delete")
	public ModelAndView delete(@RequestParam Long empno, HttpSession session) {
		if (session.getAttribute("username") == null)
			return new ModelAndView("redirect:/member/login?required");
		service.delete(empno);
		return new ModelAndView("redirect:/");
	}
}
