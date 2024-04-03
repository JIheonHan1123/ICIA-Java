package com.example.demo.dto;

import java.util.*;

import com.example.demo.entity.*;

import lombok.*;

@Data
@AllArgsConstructor
public class Page {
	private Long prev;
	private Long start;
	private Long end;
	private Long next;
	private Long pageno;
	private List<BoardListDto> list;
}






