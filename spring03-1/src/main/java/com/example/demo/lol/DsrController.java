package com.example.demo.lol;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DsrController {
	@Autowired
	private ChampionDao cDao;
	@Autowired
	private DsrDao dDao;

	@GetMapping("/dsr/list")
	public ModelAndView list() {
		List<Map<String, Object>> list = cDao.findAll();
		return new ModelAndView("dsr/list").addObject("list", list);
	}

	@GetMapping("/dsr/read")
	public ModelAndView read(Long id) {
		List<Map<String, Object>> champion = dDao.findById(id);
		return new ModelAndView("dsr/read").addObject("champion", champion);
	}
}
