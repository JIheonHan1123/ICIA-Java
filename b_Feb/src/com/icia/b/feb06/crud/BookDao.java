package com.icia.b.feb06.crud;

import java.util.ArrayList;

public class BookDao {
	ArrayList<Book> book = new ArrayList<Book>();

	public boolean save(Book b) {
		book.add(b);
		return true;
	}

	public ArrayList<Book> findAll() {
		return book;
	}

	public Book findOne(int bno) {
		for (int i = 0; i < book.size(); i++) {
			if (book.get(i).getBno() == bno) {
				return book.get(i);
			}
		}
		return null;
	}

	public boolean delete(int bno) {
		for (int i = 0; i < book.size(); i++) {
			if (book.get(i).getBno() == bno) {
				book.remove(i);
				return true;
			}
		}
		return false;
	}
}
