package a_feb_28;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

// === 타이어 ===
class Tire {
}

class 한국타이어 extends Tire {
}

class 넥센타이어 extends Tire {
}

class 브릿지스톤 extends Tire {
}

class 피렐리 extends Tire {
}

class 미날디 extends Tire {
}

class 금호타이어 extends Tire {
}

// === 렌트카 ===
@Setter
class D_렌트카 {
	private String 제조사;
	private Long 배기량;
	private Tire tire;

}

public class D_Liskov치환원칙Test3 {
	public static void main(String[] args) {
		D_렌트카 car = new D_렌트카();
		// 실제로 사용하는 타이어는 브릿지스톤(실제로는 자식 객체를 사용)
		// 참조변수는 항상 부모를 사용한다
		car.setTire(new 브릿지스톤());

		List list = new ArrayList();
	}
}