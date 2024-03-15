package com.example.demo.dao;

import java.util.ArrayList;

import com.example.demo.entity.Todo;

/* 클래스는 데이터를 가진 클래스(엔티티)와 엔티티를 처리하는 클래스로 나뉜다
	ex) 학생이 30명이 있다. 
		  성적 엔티티는 몇개? 30개
		  성적을 처리하는 클래스는 몇개? 최소화
	
	멤버들을 static으로 지정하면 객체를 생성하지 않아도 클래스 이름으로 바로 사용 가능
	= static은 클래스 이름으로 객체 없이 사용할 수 있다.
	
	static은 static끼리 모여산다.
*/

public class TodoDao {
	private static ArrayList<Todo> todos = new ArrayList<>();
	private static int tno = 1;

	public static boolean save(Todo todo) {
		todo.setTno(tno++);
		todos.add(todo);
		return true;
	}

	public static ArrayList<Todo> findAll() {
		return todos;
	}

}
