package a_feb_29;

import java.util.ArrayList;
import java.util.List;

/*
 	!!! Override !!! 
	부모는 메소드를 선언한다
		Unit 클래스가 이동할 때는 move() 메소드를 사용해라라고 정해줬다

	자식은 메소드를 정의한다
		구체적인 이동 방법은 자식들이, 각자 메소드를 정의(구현)한다
*/

class A_Marine extends A_Unit {
	public void move() {
		System.out.println("두발로 뛰어다녀요");
	}
}

class A_Ghost extends A_Unit {
	public void move() {
		System.out.println("은신해서 이동합니다");
	}
}

class A_Battlecruiser extends A_Unit {
	public void move() {
		System.out.println("느릿느릿 날아갑니다");
	}
}

public class A_리스코프치환원칙Test5 {
	public static void main(String[] args) {
		List<A_Unit> list = new ArrayList<>();

		list.add(new A_Marine());
		list.add(new A_Ghost());
		list.add(new A_Battlecruiser());

		for (A_Unit unit : list) {
			unit.move();
		}
	}
}