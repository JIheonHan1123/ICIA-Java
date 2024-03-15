package com.icia.big.sample1;

// 객체는 적절하게 초기화 되어야 함
class Human {
	// 외부에서는 접근 불가능
	private int height;
	private int weight;

	public Human() {
		this.height = 170;
		this.weight = 70;
	}
}

public class Ex9_reviewEx3 {
	public static void main(String[] args) {
		Human obj = new Human();
		// obj.height = 150; // 근데 기껏 만들어뒀는데 이런식으로 외부에서 막 바꾸면 안됨
		// 그래서 접근을 제한 => 값을 private으로 주자
		// System.out.println(obj.height); // 접근자체가 불가능
		// 그럼 값을 어떻게 읽어오나?

		// => getter/setter
		// 외부 자바라이브러리 써야 함
		// maven쓸거임
		// 1. 프로젝트폴더우클릭 > configure > convert to Maven Project
		// 2. 구글에서 lombok설치 > 실행해서 sts실행파일 선택후 설치(위치지정을 sts설치파일로 하는거임)
		// 3. sts재부팅하고 hlep -> About STS -> 맨 밑에 lombok 생겼으면 설치완료
		// 4. pom.xml 에 version태그 밑에 <dependencies></dependencies> 만들고
		// 5. 이 안에 구글 > maven repository > maven lombok 검색 > dependency태그 추가
	}
}
