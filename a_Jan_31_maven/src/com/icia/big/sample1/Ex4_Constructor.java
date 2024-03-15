package com.icia.big.sample1;

class TV {
	// 생성자(Constructor)
	// 1. 객체 생성을 전담하는 함수
	// 2. 이름은 클래스 이름과 같다
	// 3. 리턴의 개념이 아예 없다(void X)
	int 밝기; // 적절하게 초기화가 되어있어야 함 =초기 세팅값
	int 볼륨;

	TV() { // 앞에 void있으면 안됨!
		밝기 = 5;
		볼륨 = 5;
	}
}

public class Ex4_Constructor {
	public static void main(String[] args) {
		TV tv = new TV();
		System.out.println(tv.밝기);
		System.out.println(tv.볼륨);
	}
}
