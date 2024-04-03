package com.example.demo.dto;

import lombok.Data;

@Data
public class BoardReadDto {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	// 작성시간에 서식을 지정하기 위해서 LocalDateTime대신 String
	private String writeTime;
	private Long readCnt;
	private Long goodCnt;
	private Long badCnt;

	// 댓글 리스트
}
