package com.example.demo.entity;

import java.time.*;

import org.springframework.format.annotation.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	private Long empno;
	
	private String ename;
	
	private Long mgr;
	
	private Long sal;
	
	private Long comm;
	
	private String job;
	
	private Long deptno;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate hiredate;
}
