package com.example.demo.entity;

// enum : 상수들을 모아놓은 일종의 클래스
//상수의 오타를 줄이기 위해 쓴다.
//User, USER, user 이런걸 Role.USER 이렇게 쓰도록 정해놓는 것
public enum Role {
	USER, SELLER, ADMIN;
	// USER("일반회원"), SELLER("판매회원"), ADMIN("관리자");
	// USER면 한글로 일반회원이라고 출력하자는 뜻
}
