package first_servlet;

// abstract 를 붙여주면 자식은 반드시 오버라이드 해야한다(반드시 부모의 메소드를 만들어야 한다) 
abstract class Bus {
	// 부모는 메소드의 이름을 정한다 -> 추상메소드 형식으로 알려준다
	public void 이동() {
	}
}

class 시외버스 extends Bus {
	// 자식은 "상속받은 메소드를 구현"한다 (override)
	// 부모가 만든 메소드를 이름을 똑같이 만들어야 함
	public void 이동() {
		System.out.println("시외버스로 달려요");
	}
}

class 광역버스 extends Bus {
	// override
	public void 이동() {
		System.out.println("광역버스로 달려요");
	}
}

public class 상속정리 {
	public static void main(String[] args) {
		// 시외버스도 버스, 광역버스도 버스: 부모의 참조변수로 자식을 다룬다
		Bus bus1 = new 시외버스();
		Bus bus2 = new 광역버스();
	}
}
