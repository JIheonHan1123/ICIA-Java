package a_feb_28;

import lombok.AllArgsConstructor;

//======== 핸드폰 판매점(com.world.phone) =========
class S22 {
}

class S23 {
}

class S24 {
}

class 플립5 {
}

class 아이폰14 {
}

class 아이폰15 {
}

//======== 사람 (com.world.man)		    =========
@AllArgsConstructor
class 사람 {
	private S22 phone1;
	private S23 phone2;
	private S24 phone3;
	private 플립5 phone4;
	private 아이폰14 phone5;
	private 아이폰15 phone6;
}

public class D_Liskov치환원칙Test1 {
	// 구체적인 클래스를 사용하면 코드가 이지랄난다
	public static void main(String[] args) {
		사람 s = new 사람(null, null, null, new 플립5(), null, null);

	}
}
