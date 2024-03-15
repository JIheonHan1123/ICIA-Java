package com.icia.b.feb06.crud;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {
	private int ano;
	private String title;
	private String content;
	private String nickname;
	private int readcnt = 0; // instance 초기화

	public Article(int ano, String title, String content, String nickname) {
		this.ano = ano;
		this.title = title;
		this.content = content;
		this.nickname = nickname;
	}

}
