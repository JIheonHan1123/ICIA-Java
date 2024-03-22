package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBoard {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Long readcnt;
}
