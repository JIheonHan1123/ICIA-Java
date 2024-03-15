package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {

	@Autowired
	private EmpDao empDao;

	@GetMapping("/emp/list")
	public ModelAndView list() {
		List<Map<String, Object>> list = empDao.findAll();
		return new ModelAndView("emp/list").addObject("list", list);
	}

	@GetMapping("/emp/read")
	public ModelAndView read(@RequestParam Long empno) {
		Map<String, Object> read = empDao.findByEname(empno);
		return new ModelAndView("emp/read").addObject("read", read);
	}

}
