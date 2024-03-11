package a_feb_29;

import java.util.ArrayList;
import java.util.List;

// 메소드는 부모에 만들어야 한다
// 하지만 부모가 자식들의 동작을 정해줄 수는 없다

// 비유하자면 부모가 자식들에게 "행복하게 살아라"라고 방향은 제시할 수 있지
// 하지만 "행복하게 사는 구체적인 방법"은 부모가 정해줄 수 없다 -> 자식이 각자 찾아야지

class A_Unit {
	public void move() {
		System.out.println("여기 뭐라고 코딩해야 마린, 고스트, 배틀크루저가 이동할까요");
	}
}

class A_마린 extends A_Unit {
}

class A_고스트 extends A_Unit {
}

class A_배틀크루저 extends A_Unit {
}

public class A_리스코프치환원칙Test4 {
	public static void main(String[] args) {
		List<A_Unit> list = new ArrayList<>();

		list.add(new A_마린());
		list.add(new A_배틀크루저());
		list.add(new A_고스트());

		for (A_Unit unit : list) {
			unit.move();
		}
	}
}