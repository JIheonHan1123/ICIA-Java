package a_Jan_30;

import java.util.Date;

public class Ex4_Memory {
	public static void main(String[] args) {

		// 기본타입의 비교는 자바가 정해뒀다.
//		int a=10, b=10;
//		System.out.println(a==b); // True
//		

		// 참조타입의 비교
		Date d1 = new Date();
		Date d2 = new Date();
		System.out.println(d1 == d2);
//		상황에 따라 어떨 때는 년월일만 같아도되고, 어떨 때는 년월일시분초까지 같아야 같은 날짜임
//		자바는 이런 비교하는 방법을 모른다
//		객체를 ==로 비교하면 해시코드를 비교한다 => 무조건 false나옴
//		객체를 비교할 때는 ==를 사용하지 말자

		// int x; // 이딴식으로 하면 안됨
		int x = 0;
		// Date d3 // 참조변수도 마찬가지로 참조변수만 달람 있으면 안됨
		Date d3 = null;

	}
}
