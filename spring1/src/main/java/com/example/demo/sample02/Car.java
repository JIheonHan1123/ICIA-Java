package com.example.demo.sample02;

// SOLID
//-> 단일책임 원칙: 클래스는 한가지 역할만 담당한다 (클래스의 변경 이유는 1가지여야 한다)
//-> 개방폐쇄 원칙: 다른 클래스가 업그레이드 하였을 때 나는 그 혜택을 받아야하지만(개방), 코드를 변경 X (폐쇄)
//							 =개선에 대해서는 열려있고 변경에 대해서는 닫혀있다
//-> 리스코프치환 원칙: 부모와 자식은 언제나 치환가능해야한다. (자식은 부모에 없는 메소드를 추가하면 X)
//-> 인터페이스분리 원칙: 인터페이스는 분리해서 작게 만들어라
//-> 의존성역전 원칙

// 1. 부모클래스는 메소드의 이름을 정해준다 -> 추상메소드
// 2. 추상클래스: 추상메소드를 가지는 클래스 (일반 메소도 가질 수 있다)
// 3. 인터페이스: 추상메소드만 가지는 일종의 클래스 (자식들의 설계도)
// 					  되도록 작게 만들자
// 3-1. @FunctionalInterface: 추상메소드 1개가 들었다

public class Car {
	private Tire tire;

	public Car(Tire tire) {
		this.tire = tire;
	}

	public void drive() {
		this.tire.떼굴떼굴();
	}

	public void 타이어교환(Tire tire) {
		this.tire = tire;
	}
}