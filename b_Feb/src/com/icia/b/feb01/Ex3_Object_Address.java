package com.icia.b.feb01;

public class Ex3_Object_Address {
	private String name;
	private String address1;
	private String address2;

	public Ex3_Object_Address(String name, String address1, String address2) {
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
	}

	// 주소 출력
	public void printAddress() {
		System.out.println(address1 + " " + address2);
	}
}
