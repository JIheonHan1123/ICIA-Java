package a_feb_26_todo;

import java.time.LocalDate;

// 할일: 번호, 할일, 작성일, 완료여부

// js의 경우: {tno:1, title:'자바공부', finish:ture} 이렇게 만들었다면
// 자바의 경우 설계도인 클래스를 만든 다음에 객체를 생성한다
public class Todo {
	// 접근제어자 (access modifier)
	// public: 누구나 접근할 수 있다
	// private: 허락된 사용자만 값을 읽고 쓸 수 있다
	private Long tno;
	private String title;
	private LocalDate wirteday;
	private Boolean finish; // boolean도 Wrapper Class가 있음

}
