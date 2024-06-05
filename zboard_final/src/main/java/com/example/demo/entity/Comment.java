package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
	private Long cno;
	private Long bno;
	private String content;
	private String writer;
	private LocalDateTime writeTime;
}
