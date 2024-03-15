package com.example.demo.march14;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// 어노테이션은 일종의 클래스
// @Component - 스프링 빈을 생성해주는 어노테이션
// 이 @Component의 자식들이 @Controller, @Service, @Repository(@Mapper)
@Controller
public class DeptController2 {
	@Autowired // DI해주는 어노테이션
	private DeptDao2 deptDao;

	@GetMapping("/dept2/list") // Get요청 처리해주는 어노테이션
	public ModelAndView list() {
		List<Map<String, Object>> list = deptDao.findAll();
		return new ModelAndView("dept2/list").addObject("list", list);
	}

	@GetMapping("/dept2/read")
	public ModelAndView read(@RequestParam Long deptno) {
		Map<String, Object> dept = deptDao.findByDeptno(deptno);
		return new ModelAndView("dept2/read").addObject("dept", dept);
	}
}
