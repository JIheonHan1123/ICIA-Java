package com.icia.big.sample1;

class 아메리카노 {
	int 샷;
	int 시럽;

	// 보통 생성자는 public (누구나 접근가능)
	public 아메리카노() {
		샷 = 2;
		시럽 = 0;
	}

	// 자바에서 이름은 겹칠 수 없다
	// 단, 함수의 경우 인자의 개수 또는 타입이 다르다면 같은 이름 사용 가능
	// = overload
	public 아메리카노(int 샷추가) {
		샷 = 2 + 샷추가;
	}
}

public class Ex5_Contstructor {
	public static void main(String[] args) {
		아메리카노 a1 = new 아메리카노();
		아메리카노 a2 = new 아메리카노(2);
		System.out.println(a2.샷);
	}
}
