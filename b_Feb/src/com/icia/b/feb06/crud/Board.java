package com.icia.b.feb06.crud;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

// 익명게시판: 글번호, 제목, 내용, 작성자, 작성일, 조회수, 비밀번호
@Getter
@Setter
public class Board {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private LocalDate wirteday = LocalDate.now(); // 기본값 줄 수 있음. 대신 못 바꿈 = 필드 초기화: 필드 만들면서 바로 해도 되고 생성자에서 해도 된다
	private int readcnt = 0;
	private String password;

	public Board(int bno, String title, String content, String writer, String password) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
	}
}
