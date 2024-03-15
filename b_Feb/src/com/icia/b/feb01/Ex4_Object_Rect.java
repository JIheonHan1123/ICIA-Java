package com.icia.b.feb01;

class Rect {
	private int width;
	private int height;
	private int resultArea;
	private double resultPyung;

	public Rect() {
	}

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
		this.resultArea = this.width * this.height;
		this.resultPyung = this.resultArea / 3.3;

	}

	public void printArea() {
		System.out.println("너비는 " + resultArea);
	}

	public void printPyung() {
		System.out.println("평은  " + resultPyung);
	}

}

// 아래의 코드가 작동하도록 클래스 생성
public class Ex4_Object_Rect {
	public static void main(String[] args) {
		Rect r = new Rect(10, 20);

		// 면적은 200
		r.printArea();

		// 평은 60.60606060606061
		r.printPyung();
	}
}
