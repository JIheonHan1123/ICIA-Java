package com.example.demo.sample01;

/*
구상(concrete) 클래스를 부모클래스 없이 직접 사용하면 안된다
- 자동차 클래스가 구상 클래스인 한국타이어와 넥센타이어를 직접 사용(의존)하면
- 불필요한 복잡성 : 타이어별로 따로 처리하는 코드가 필요
- 타입 안정성 문제 : null 객체는 오류가 발생할 수 있다
- 확장이 어려움 : 새로운 타이어를 추가되면 생성자를 변경하고 교체 메소드를 추가해야 한다
*/

public class 자동차 {
	private 한국타이어 tire1;
	private 넥센타이어 tire2;

	public 자동차(한국타이어 tire1, 넥센타이어 tire2) {
		this.tire1 = tire1;
		this.tire2 = tire2;
	}

	// 필드가 null 일 수 있으니 null check 를 해야한다
	// null 인 객체를 사용하면 Null Pointer Exception
	public void drive() {
		if (this.tire1 != null) {
			this.tire1.떼굴떼굴();
		} else if (this.tire2 != null) {
			this.tire2.떼굴떼굴();
		}
	}

	public void 타이어교환(한국타이어 tire) {
		this.tire1 = tire;
	}

	public void 타이어교환(넥센타이어 tire) {
		this.tire2 = tire;
	}
}