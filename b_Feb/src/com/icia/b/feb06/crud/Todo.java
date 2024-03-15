package com.icia.b.feb06.crud;

// 자바의 날짜 클래스는 대대로 문제가 많았다
// java8에서 jodatime 라이브러리를 도입
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

// 클래스의 멤버: 생성자, 필드, 메소드
@Getter // private 필드를 읽어오는 메소드 추가
@Setter // private 필드를 저장하는 메소드 추가
public class Todo {
	// 필드(field): 클래스를 구성하는 변수들
	private int tno;
	private String title;
	private LocalDate writeday;
	private boolean finish;

	// 생성자: 객체 생성을 담당하는 메소드. 리턴이 없고 이름은 클래스 이름과 같다
	public Todo() {
		// 기본생성자: 인자가 없는 생성자
	}

	public Todo(int tno, String title) {
		this.tno = tno;
		this.title = title;
		// 요즘 클래스들은 객체를 만들 때 생성자 대신 다른 메소드를 사용하는 경우가 많음
		this.writeday = LocalDate.now();
		this.finish = false;
	}
}
