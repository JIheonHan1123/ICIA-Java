package a_feb_29;

import java.util.ArrayList;
import java.util.List;

// 실제로 사용하는 구체적인 클래스를 구상 클래스(<->추상 클래스)라고 한다
// 구상 클래스를 직접 사용하면 각각의 구상 클래스마다 처리하는 코드가 필요해 비효율적이다

class 마린 {
	public void move() {
		System.out.println("두발로 뛰어다녀요");
	}
}

class 고스트 {
	public void move() {
		System.out.println("은신해서 이동합니다");
	}
}

class 배틀크루저 {
	public void move() {
		System.out.println("느릿느릿 날아갑니다");
	}
}

public class A_리스코프치환원칙Test2 {
	public static void main(String[] args) {
		// 구상 클래스인 마린 따로, 고스트 따로, 배틀크루저 따로 부대 지정
		List<마린> 부대1 = new ArrayList<>();
		List<고스트> 부대2 = new ArrayList<>();
		List<배틀크루저> 부대3 = new ArrayList<>();

		// 마린, 고스트, 배틀크루저 부대마다 따로 따로 이동을 반복한다
		for (마린 ob : 부대1) {
			ob.move();
		}
		for (고스트 ob : 부대2) {
			ob.move();
		}
		for (배틀크루저 ob : 부대3) {
			ob.move();
		}
	}
}