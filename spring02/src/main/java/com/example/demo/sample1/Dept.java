package com.example.demo.sample1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // 마이바티스에서 사용하는 객체는 반드시 기본 생성자가 있어야 한다
public class Dept {
	private Long deptno;
	private String dname;
	private String loc;
}