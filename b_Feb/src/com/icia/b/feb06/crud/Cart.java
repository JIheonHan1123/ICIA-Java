package com.icia.b.feb06.crud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Cart { // 장바구니 클래스
	private int productNum;
	private String productName;
	private int qty; // 수량
	private int price;
	private String address;
}
