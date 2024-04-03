package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardReadDto;
import com.example.demo.dto.BoardUpdateDto;
import com.example.demo.dto.BoardWriteDto;
import com.example.demo.dto.Page;
import com.example.demo.service.BoardService;

import jakarta.validation.Valid;

@Validated // 컨트롤러 전체의 검증을 활성화 -> 인자에 @Valid 붙여주고 BindingResult도 적어줘야 함 (77라인 참고)
@Controller
public class BoardController {
	@Autowired
	BoardService service;

	// 글 목록
	@GetMapping("/")
	public ModelAndView list(@RequestParam(defaultValue = "1") Long pageno) {
		// 검증했을 때 @RequestParam과 @NotNull, @NotEmpty 동시에 사용 X -> 발생하는 예외가 다름
		// 검증할 경우에는 @NotNull, @NotEmpty를 사용하자
		// 단, 기본값을 지정할 때는 @RequestParam 사용

		Page page = service.findAll(pageno);
		return new ModelAndView("board/list").addObject("page", page);
	}

	// 글 작성 Get
	@PreAuthorize("isAuthenticated()") // 관리자가 없다면 @Secured("ROLE_USER")랑 똑같음
	@GetMapping("/board/write")
	public void write() {
	}

	// 글 작성 Post
	@Secured("ROLE_USER")
	@PostMapping("/board/write") // 관리자가 있다면 관리자는 글쓰기를 하면 안되니까 @Secured로 작업하는게 맞다
	public ModelAndView write(@Valid BoardWriteDto dto, BindingResult br, Principal principal) {
		// principal은 로그인한 아이디 가져올 때 가져온다
		// 로그인을 했으면 로그인한 아이디가 담겨있고 로그인을 안했으면 null이 담겨있다
		// @Secured 어노테이션이 있기 때문에 null체크는 안해도 된다

		// 시퀀스를 리턴받아보자 (dao가 생성하는 값을 리턴받아보자)
		Long bno = service.save(dto, principal.getName());
		System.out.println(bno);
		return new ModelAndView("redirect:/");
	}

	// 글 읽기
	@GetMapping("/board/read")
	public ModelAndView read(Long bno, Principal principal) {
		String loginId = principal == null ? null : principal.getName();
		BoardReadDto dto = service.read(bno, loginId);
		if (dto == null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("board/read").addObject("dto", dto);
	}

	// 글 변경 (작성자인 경우만 변경 가능)
	@Secured("ROLE_USER")
	@PostMapping("/board/update")
	public ModelAndView update(@ModelAttribute @Valid BoardUpdateDto dto, BindingResult br, Principal principal, RedirectAttributes ra) { // BindingResult로 뭘 하지는 않는데 검증할 때 꼭 적어줘야함
		Boolean result = service.update(dto, principal.getName());
		if (result == false) {
			ra.addFlashAttribute("msg", "잘못된 작업입니다");
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("redirect:/board/read?bno=" + dto.getBno());
	}

	// 글 삭제 (작성자인 경우만 삭제 가능)
	// @PostMapping("/board/delete")
}
