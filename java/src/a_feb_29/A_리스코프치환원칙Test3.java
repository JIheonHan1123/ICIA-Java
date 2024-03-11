package a_feb_29;

import java.util.ArrayList;
import java.util.List;

// 부모클래스는 추상적인 카테고리, 분류, 스펙에 해당한다
// 부모클래스로 작업하면 자식들도 동작한다

class Unit {
}

class Marine extends Unit {
	public void move() {
		System.out.println("두발로 뛰어다녀요");
	}
}

class Ghost extends Unit {
	public void move() {
		System.out.println("은신해서 이동합니다");
	}
}

class Battlecruiser extends Unit {
	public void move() {
		System.out.println("느릿느릿 날아갑니다");
	}
}

public class A_리스코프치환원칙Test3 {
	public static void main(String[] args) {
		// Unit의 리스트를 만들면 마린, 배틀크루저, 고스트를 모두 담을 수 있다
		List<Unit> list = new ArrayList<>();

		list.add(new Marine());
		list.add(new Battlecruiser());
		list.add(new Ghost());

		// 부모 참조변수는 부모의 멤버에만 접근할 수 있다
		// move 메소드를 마린, 배틀크루저, 고스트가 가지고 있으면 Unit 참조변수로 접근이 불가능!!!!!
		// 메소드는 반드시 부모에 만들어야 한다
		for (Unit unit : list) {
//			unit.move();
		}
	}
}