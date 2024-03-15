package com.example.demo.entity;

import lombok.Data;

// Entitiy는 DB에 저장하는 클래스

@Data
public class Dept {
	private Long deptno;
	private String dname;
	private String loc;
}
