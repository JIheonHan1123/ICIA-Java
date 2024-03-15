package com.icia.b.feb06.crud;

import java.util.ArrayList;

// mock 객체 (가짜 객체)
public class ArticleDao {
	ArrayList<Article> list = new ArrayList<Article>();

	public boolean save(Article article) {
		list.add(article);
		return true;
	}

	public ArrayList<Article> findAll() {
		return list;
	}

	public Article findOne(int ano) {
		// list의 0번째 원소부터 마지막 원소까지 index로 접근: list.get(i)
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAno() == ano) {
				return list.get(i);
			}
		}
		// null: 객체가 없다.
		return null;
	}

}
