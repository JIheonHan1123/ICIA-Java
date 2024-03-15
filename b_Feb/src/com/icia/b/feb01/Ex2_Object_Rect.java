package com.icia.b.feb01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor // 클래스의 모든 필드 값을 파라미터로 받는 생성자를 자동생성. 클래스의 모든 필드를 한 번에 초기화할 수 있다
@NoArgsConstructor // 기본생성자
@Getter
@Setter
public class Ex2_Object_Rect {
	private int width;
	private int height;
}
