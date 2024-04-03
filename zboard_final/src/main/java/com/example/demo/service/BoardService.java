package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.BoardListDto;
import com.example.demo.dto.BoardReadDto;
import com.example.demo.dto.BoardUpdateDto;
import com.example.demo.dto.BoardWriteDto;
import com.example.demo.dto.Page;
import com.example.demo.entity.Board;

import jakarta.validation.Valid;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	@Value("10")
	private Long 페이지당글개수;
	@Value("5")
	private Long 블록당페이지개수;

	@Transactional(readOnly = true) // 이 함수는 읽기만 한다 -> 데이터를 보호할 필요가 없다
	public Page findAll(Long pageno) {
		// 1. pageno startRownum endRownum (pageno-1)*10 +1
		// 1 1 10 0 1
		// 2 11 20 10 11
		// 3 21 30 20 21

		Long startRownum = (pageno - 1) * 페이지당글개수 + 1;
		Long endRownum = startRownum + 페이지당글개수 - 1;
		List<BoardListDto> list = boardDao.findAll(startRownum, endRownum);

		// 2. 페이지의개수를 계산
		// 글의개수 페이지의개수 글의개수/10+1 (글의개수-1)/10+1
		// 118 12 12 12
		// 119 12 12 12
		// 120 12 13 12
		// 121 13 13 13
		Long count = boardDao.count();
		Long 페이지개수 = (count - 1) / 페이지당글개수 + 1;

		// 3. prev, start, end, next를 계산 - 페이지의 개수 13개라면
		// pageno prev start end next
		// 1~5 0 1 5 6
		// 6~10 5 6 10 11
		// 11~13 10 11 13 0

		Long prev = (pageno - 1) / 블록당페이지개수 * 블록당페이지개수;
		Long start = prev + 1;
		Long end = prev + 블록당페이지개수;
		Long next = end + 1;
		// pageno->11이라면 prev:10, start:11, end:15, next:16

		// 4. end가 페이지의 개수보다 같거나 크다면 end, next를 바꿔라
		if (end >= 페이지개수) {
			end = 페이지개수;
			next = 0L;
		}

		return new Page(prev, start, end, next, pageno, list);
	}

	public Long save(@Valid BoardWriteDto dto, String loginId) {
		Board board = new Board(null, dto.getTitle(), dto.getContent(), loginId, LocalDateTime.now(), 0L, 0L, 0L);
		boardDao.save(board);

		// selectKey: 마이바티스가 자동생성한 값을 엔티티에 담아준다
		return board.getBno();
	}

	// 글이 없으면 null 리턴
	// 글이 있고 + 로그인했고 + 작성자가 아님 = 읽기횟수 증가

	// 비로고으니또는
	public BoardReadDto read(Long bno, String loginId) {
		// 글이 존재하는지 확인
		String writer = boardDao.findWriterByBno(bno);
		// 1. 글이 없으면 null리턴
		if (writer == null) {
			return null;
		}
		// 2. 로그인 했고 작성자가 아니라면 조회수 증가
		if (loginId != null && loginId.equals(writer) == false) {
			boardDao.increaseReadCnt(bno);
		}
		return boardDao.findByBno(bno);
	}

	// 사람이 생각하는 논리적인 작업은 여러줄의 sql: transaction
	// 물건을 산다 = 돈을준다+물건을 받는다+거스름돈을 받는다
	// transaction을 구성하는 동작은 모두 성공하거나 모두 실패해야한다

	@Transactional // 다같이 성공하거나 다같이 실패하거나
	public Boolean delete(Long bno, String loginId) {
		String writer = boardDao.findWriterByBno(bno);
		if (writer == null)
			return false;
		if (writer.equals(loginId) == false)
			return false;
		// commentDao.deleteByBno(bno);
		return boardDao.delete(bno) == 1L;
	}

	public Boolean update(BoardUpdateDto dto, String loginId) {
		String writer = boardDao.findWriterByBno(dto.getBno());
		if (writer == null)
			return false;
		if (writer.equals(loginId) == false)
			return false;
		return boardDao.update(dto.getTitle(), dto.getContent(), dto.getBno()) == 1L;
	}
}
