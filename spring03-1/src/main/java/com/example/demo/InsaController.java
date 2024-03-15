package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InsaController {
	@Autowired
	private InsaDao insaDao;
	@Autowired
	private EmpService service;

	@GetMapping("/insa")
	public ModelAndView sample(Integer year) {
		service.insa(year);
		return null;
	}

}
