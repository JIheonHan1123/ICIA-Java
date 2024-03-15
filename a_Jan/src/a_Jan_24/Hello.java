// package 	자바의 모듈. 클래스들의 집합. 일단 pass
package a_Jan_24;

// public	다른 사람이 사용할 수 있다 <-> private
// class		자바는 모든 것이 클래스 (사실 파이썬도 모든 것이 클래스이지만 숨겨뒀다)
public class Hello {
	
	// 자바에서 프로그램을 실행하려면 반드시 main 이라는 함수를 만들어야한다. 
	// main 함수의 인자는 String[] ar이다. 이것도 일단 pass
	
	// static 현재 설명 불가능... 일단 pass
	
	// void는 결과 값이 없다. (함수 앞에 반드시 결과 값의 타입을 적는다)
	// 그렇다고 타입은 아님. 그냥 함수의 결과값이 없다라는 표현
	public static void main(String[] ar) { // main함수는 무조건 public이어야 실행된다
		// cf) 함수와 메소드의 차이 (메소드는 클래스 안에 소속된 함수)
		// 자바의 모든 함수는 메소드이다. => 자바의 모든 함수는 . 을 찍고 사용한다.
		System.out.println("Hello World");
	} 
}