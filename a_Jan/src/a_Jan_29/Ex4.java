package a_Jan_29;

public class Ex4 {
	public static void main(String[] args) {
		int kor =  80;
		int eng =  80;
		int math =  82;
		int tot = kor + eng + math;
		double avg = tot/3;
		// 실제로는 80.666... 나오는데 80.0이 나온다
		// 자바에서 나눗셈 계산이 즉 몫 계산이기 때문에 80이 나오고
		// 그 80을 실수형 변수에 대입했기 때문에 80.0이 나온다.
		System.out.println(avg);
		
		// 80.666...이 나오게 하고 싶으면 형변환을 해줬어야 함
		// double avg = (double)tot/3;
	}
}