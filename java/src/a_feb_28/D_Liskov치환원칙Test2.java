package a_feb_28;

import lombok.AllArgsConstructor;

//======== 핸드폰 판매점(com.world.phone) =========
//부모의 참조변수는 자식을 가리킬 수 있다
//Phone p = new SS22();
//p = new S플립5();

class Phone {
}

class SS22 extends Phone {
}

class SS23 extends Phone {
}

class SS24 extends Phone {
}

class S플립5 extends Phone {
}

class I아이폰14 extends Phone {
}

class I아이폰15 extends Phone {
}

//======== 사람 (com.world.man)		    =========
@AllArgsConstructor
class Saram {
	private Phone phone;
}

public class D_Liskov치환원칙Test2 {
	// 구체적인 클래스를 사용하면 코드가 1번예제처럼 난리난다
	// 추상적인 부모 클래스로 작업해야 한다
	public static void main(String[] args) {
		Saram s = new Saram(new I아이폰15());
	}
}