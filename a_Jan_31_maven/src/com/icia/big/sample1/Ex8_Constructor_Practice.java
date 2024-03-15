package com.icia.big.sample1;

// 학생은 국적, 이름, 나이로 구성
// 국적의 기본값은 대한민국
class Student {
	String country;
	String name;
	int age;

	public Student() {
		this.country = "대한민국";
	}

	public Student(String name, int age) {
		this.country = "대한민국";
		this.name = name;
		this.age = age;
	}

	public Student(String country, String name, int age) {
		this.country = country;
		this.name = name;
		this.age = age;
	}
}

public class Ex8_Constructor_Practice {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student("미국", "트럼프", 20);
		System.out.println(s1.age);
		System.out.println(s2.age);
	}
}
