package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	// LocalDate, LocalDateTime -> date(시분일'초'까지), timestamp(1/1000초)
	private LocalDateTime writeTime;
	private Long readCnt;
	private Long goodCnt;
	private Long badCnt;
}
