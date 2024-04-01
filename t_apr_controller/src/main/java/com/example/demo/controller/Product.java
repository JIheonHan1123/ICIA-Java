package com.example.demo.controller;

import lombok.*;

@Data
@AllArgsConstructor
public class Product {
	private Long pno;
	private String pname;
	private Long price;
}
