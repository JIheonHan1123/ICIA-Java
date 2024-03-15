package com.icia.big.sample1;

// 객체 지향 프로그래밍 (Object Oriented Programming)
/*
   국어, 영어
   총점계산()
   평균계산()
   
   class 성적 {
   		국어;
   		영어;
   		총점계산();
   		평균계산();
   }
*/

class 성적 {
	String name;
	int kor;
	int eng;
	int tot;

	void 총점계산() {
		tot = kor + eng;
	}
}

public class Ex2_Object {
	public static void main(String[] args) {
		성적 s1 = new 성적();
		System.out.println(s1.hashCode());
	}
}
