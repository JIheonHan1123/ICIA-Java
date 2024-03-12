package com.example.demo.sample1;

import lombok.Data;

@Data // 생성자를 제외하고 세터, 게터등을 한방에 지정하는 어노테이션
public class Dept {
	private Long deptno;
	private String dname;
	private String loc;
}
