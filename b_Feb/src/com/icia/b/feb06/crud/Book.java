package com.icia.b.feb06.crud;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 필드 값을 전부 다 받아오는 경우에는 lombok이 생성자를 만들어준다
public class Book { // 서점
	private int bno;
	private String title;
	private String writer;
	private String publisher;
	private String detail; // 책 소개
	// 일반적으로 DB에서는 파일을 저장하지 않는다
	// 보통은 디스크에 사진을 저장하고 사진 이름을 DB에 저장
	private String img;
	private LocalDate publicationDate;
	private int price;

}
