package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.sample02.Car;
import com.example.demo.sample02.HankukTire;
import com.example.demo.sample02.NexenTire;
import com.example.demo.sample02.Tire;

public class Sample02Test {
	@Test
	public void test1() {
		// 부모인터페이스로 사용하면 쉽고 편리한 코드가 나온다
		Tire tire = new HankukTire();
		Car car = new Car(tire);
		car.drive();

		car.타이어교환(new NexenTire());
		car.drive();

		// 부모를 사용한다지만 결국 개발자는 구상클래스는 사용하고 있잖아?
	}
}