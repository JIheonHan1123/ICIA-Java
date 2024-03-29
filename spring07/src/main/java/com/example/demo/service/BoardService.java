package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Page;
import com.example.demo.entity.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	@Value("10")
	private Long BOARD_PER_PAGE;
	@Value("5")
	private Long PAGES_PER_BLOCK;

	public Page findAll(long pageno) {
		// 1 -> 0~10, 2 -> 11~20 ...
		Long startRownum = (pageno - 1) * BOARD_PER_PAGE + 1;
		Long endRownum = startRownum + BOARD_PER_PAGE - 1;
		List<Board> list = boardDao.findAll(startRownum, endRownum);
		Long count = boardDao.count();

		// 페이지의 개수
		Long countOfPage = (count - 1) / BOARD_PER_PAGE + 1;

//		pageno가 1~5			prev:0		start:1		end:5		next:6
//		pageno가 6~10		prev:5		start:6		end:10		next:11
//		pageno가 11~13		prev:10		start:11		end:13		next:0
		Long prev = ((pageno - 1) / PAGES_PER_BLOCK) * PAGES_PER_BLOCK;
		Long start = prev + 1;
		Long end = prev + PAGES_PER_BLOCK;
		Long next = end + 1;

		// pageno가 11~13일 경우 end는 15, next는 16
		if (end >= countOfPage) {
			end = countOfPage;
			next = 0L;
		}

		return new Page(prev, start, end, next, pageno, list);
	}
}