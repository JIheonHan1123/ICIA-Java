package com.icia.b.feb01;

// 객체: 현실에 존재하는 사물이나 서류(중 프로그래밍 대상)
// 클래스: 컴퓨터에서 객체를 생성하기 위한 설계도(필드, 생성자, 메소드)

// 메소드
// 필드의 값을 변경하는 메소드: set필드명 -> setter
// 필드의 값을 읽어내는 메소드: get필드명 -> getter
public class Ex1_Object_Rect {
	// 필드: 객체가 가지는 정보 -> private로 지정해 보호
	private int width;
	private int height;
	private int area;

	// 생성자: 객체를 생성할 때 사용하는 메소드
	public Ex1_Object_Rect(int width, int height) {
		this.width = width;
		this.height = height;
		this.area = this.width * this.height;
	}

	// 기본생성자 -> 스프링쓸 때 무조건 있어야 함 -> 그냥 무조건 만들어라
	public Ex1_Object_Rect() {
	}

	// getter/setter => 이거 자동으로 만들어주는게 lombok
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

}
