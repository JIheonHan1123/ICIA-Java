package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Board;
import com.example.demo.dto.Pagination;

// Tag Library: jsp에서 자바함수를 html의 tag 비슷하게 사용할 수 있게 해주는 기술
//						ex) <c:if>, <c:forEach> ..
//						별로 중요하지 않다 -> 거의 망했다

// 다만, Java Standard Tag Library (JSTL)만 사용하고 있다

// 스프링부트는 JSTL을 지원하지 않는다 -> !!!!!  pom.xml 설정 필요 !!!!!!
// 스프링부트3 JSTL이라고 검색해야함. 스프링부트2면 안됨 -> 강사님 깃허브 spring01에 pom.xml 참고

@Controller
public class SampleController4 {

	// private: 컨트롤러 내부에서 사용할 메소드
	private List<Board> getList() {
		List<Board> list = new ArrayList<>();
		for (Long i = 10L; i > 0L; i--) {
			list.add(new Board(i, i + "번째 글", "spring", LocalDate.now(), 10L));
		}
		return list;
	}

	//
	// if, chose문 연습
	@GetMapping("/sample4/jstl1")
	public ModelAndView jstl1() {
		ModelAndView mav = new ModelAndView("sample4/jstl1");
		return mav.addObject("username", "spring");
	}

	// foreach문 연습
	@GetMapping("/sample4/jstl2")
	public ModelAndView jstl2() {
		ModelAndView mav = new ModelAndView("sample4/jstl2");
		return mav.addObject("list", getList());
	}

	@GetMapping("/sample4/jstl3")
	public ModelAndView jstl3() {
		Pagination p = new Pagination(0L, 1L, 5L, 6L, 2L);
		ModelAndView mav = new ModelAndView("sample4/jstl3");
		return mav.addObject("list", getList()).addObject("pagination", p);
	}

	@GetMapping("/sample4/jstl4")
	public ModelAndView jstl4(@RequestParam(defaultValue = "1") Long pageno) {
		// @RequestParam을 안쓰면 타입을 내가 정해줘야함
		// /sample4/jstl3?pageno=11 이렇게 하면 되는데
		// 만약 /sample/jstl3 이렇게치고 들어오면 pageno가 null -> 형변환 해주면서 에러남 => default값 정해주기
		System.out.println(pageno);
		return null;
	}
}
