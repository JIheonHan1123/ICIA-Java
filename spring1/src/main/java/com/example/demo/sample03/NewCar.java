package com.example.demo.sample03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.sample02.Tire;

// 의존성 주입
// 1. 스프링은 프로젝트에서 @Component가 붙은 클래스의 객체를 생성 -> 스프링 bean
// 2. 생성한 객체는 스프링에 등록
// 3. @Autowired 어노테이션을 만나면 객체를 주입한다
// 스프링 bean 이어야 @Autowired 가 된다

@Component
public class NewCar {
	// 스프링에게 Tire 주입을 요청
	@Autowired
	private Tire tire;

	public void drive() {
		this.tire.떼굴떼굴();
	}
}