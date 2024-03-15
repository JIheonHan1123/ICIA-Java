package com.icia.big.sample1;

class Americano {
	int 샷;
	double 시럽;

	public Americano() {
		this.샷 = 2;
	}

	public Americano(int 추가샷) {
		this.샷 = 2 + 추가샷;
	}

	public Americano(double 시럽) {
		this.시럽 = 시럽; // this를 붙이면 클내스 내부에서 나의 멤버를 의미
		// this.시럽 = 함수 밖에 있는 시럽
		// 시럽 = 함수 안에 인자로 들어오는 시럽
	}

	public Americano(int 추가샷, double 시럽) {
		this.샷 = 2 + 추가샷;
		this.시럽 = 시럽;
	}
}

public class Ex6_Constructor_Overload {
	public static void main(String[] args) {
		// 만약 자바에서 함수 이름이 서로 반드시 달라야 한다면
		// 정수 2개를 더하는 함수와 실수 2개를 더하는 함수가 있을 때
		// int sum(int a, int b){}
		// double ?(double a, double b) {}
		// 위에서 sum이라는 이름을 사용해버림. 으윽? 얘도 덧셈인데 뭐라 이름 지을거냐
		// 여기서 끝이 아니고 실수+정수하는 덧셈은 또 뭐라고 이름 지을거냐
		//
		// => 그래서 함수의 경우 "인자의 개수 또는 타입"이 다르다면 같은 이름을 사용 가능하다.
		// = 이 개념이 overload

	}
}
