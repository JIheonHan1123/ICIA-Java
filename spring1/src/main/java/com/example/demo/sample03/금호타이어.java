package com.example.demo.sample03;

import org.springframework.stereotype.Component;

import com.example.demo.sample02.Tire;

@Component
public class 금호타이어 implements Tire {
	@Override
	public void 떼굴떼굴() {
		System.out.println("금호 떼굴 타이어 떼굴");
	}
}