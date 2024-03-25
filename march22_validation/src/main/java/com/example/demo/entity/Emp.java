package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Emp {
	// 숫자 필수입력
	@NotNull(message = "사번은 필수입력입니다")
	private Long empno;

	// 문자열 필수입력
	@NotEmpty(message = "이름은 필수입력입니다")
	private String ename;

	private Long mgr;

	private String job;

	private LocalDate hiredate;

	@NotNull(message = "급여는 필수입력입니다")
	private Long sal;

	private Long comm;

	private Long deptno;
}
