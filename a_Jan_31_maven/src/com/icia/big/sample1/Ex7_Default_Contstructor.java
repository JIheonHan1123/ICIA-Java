package com.icia.big.sample1;

// 생성자는 필수!!
// 기본 생성자: default constructor
// = 클래스에 생성자가 없으면 자바가 클래스와 이름이 똑같은 생성자를 추가한다
/*
 	class Sample {
 	}
 	이 코드랑 
 	
    class Sample {
		public Sample() {
		}
	}
	이 코드랑 똑같은 거임
*/

// But!!!
// 생성자가 하나라도 있으면 기본생성자를 추가하지 않는다.
// 나중에 스프링가면 기본생성자는 무조건 있어야해서 만들어주는게 좋음 
/*
    class Sample {
		public Sample(int a) {
		}
	} 
    main에 있는 Sample obj = new Sample(); 에러나는 것을 확인할 수 ㅇ
*/

class Sample {
}

public class Ex7_Default_Contstructor {
	public static void main(String[] args) {
		Sample obj = new Sample();
	}
}
