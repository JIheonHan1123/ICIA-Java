package com.icia.b.feb01;

// 필드: 예금주, 잔액
// 생성자: Account a = new Account("홍길동");
// 메소드
// 예금메소드: 잔액증가
// 출금메소드: 잔액감소
// 잔액출력메소드: 잔액: ???

class Account {
	private String name;
	private int totMoney;

	public Account() {
	}

	public Account(String name) {
		this.name = name;
	}

	public void moreMoney(int money) {
		this.totMoney += money;
		System.out.println("잔액 " + money + "원 증가: " + this.totMoney);
	}

	// 출금기능 여러가지 방법
//	public void lessMoney(int mMoney) {
//		this.money -= mMoney;
//	}
//	public int lessMoney(int mMoney) {
//		this.money -= mMoney;
//		return mMoney;
//	}
	public boolean lessMoney(int money) {
		if (this.totMoney >= money) {
			this.totMoney -= money;
			System.out.println("잔액 " + money + "원 감소: " + this.totMoney);
			return true;
		}
		System.out.println("!!잔액부족!!");
		return false;
	}

	public void printMoney() {
		System.out.println(this.name + "님의 현재 잔액은: " + this.totMoney);
	}
}

public class Ex6_Obj_Account {
	public static void main(String[] args) {
		Account a = new Account("홍길동");
		a.printMoney();

		a.moreMoney(90);
		a.printMoney();

		a.lessMoney(20);
		a.printMoney();

		a.lessMoney(200);
		a.printMoney();
	}
}
