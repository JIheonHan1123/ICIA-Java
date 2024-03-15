package com.icia.b.feb06.crud;

import java.util.ArrayList;

// Data Access Object: DB에
public class TodoDao {
	// 다이아몬드 연산자로 타입을 제한한다
	ArrayList<Todo> list = new ArrayList<Todo>();

	public boolean save(Todo todo) {
		list.add(todo);
		// 추가하는 연산이 실패할 확률은 거의 없다
		return true;
	}

	public ArrayList<Todo> findAll() {
		return list;
	}

	public Todo findOne(int tno) {
		// list의 0번째 원소부터 마지막 원소까지 index로 접근: list.get(i)
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTno() == tno) {
				return list.get(i);
			}
		}
		// null: 객체가 없다.
		return null;
	}

	public boolean update(int tno, String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTno() == tno) {
				list.get(i).setTitle(title);
				return true;
			}
		}
		return false;
	}

	public boolean delete(int tno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTno() == tno) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
}
