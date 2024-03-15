package com.example.demo.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Todo {
	private int tno;
	private String title;
	private LocalDate writeday = LocalDate.now();
	private boolean finish = false;

	public Todo(String title) {
		this.title = title;
	}
}
