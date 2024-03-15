package com.icia.b.feb06.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ArticleDaoTest {
	// 테스트 할 객체 생성
	ArticleDao dao = new ArticleDao();

	// junit으로 테스트를 돌리는 함수는 반드시 public void
	@Test
	public void saveTest() {
		assertEquals(true, dao.save(new Article(1, "1번글", "없어", "spring")));
	}

	@Test
	public void findAllTest() {
		assertEquals(0, dao.findAll().size());
	}

	@Test
	public void findOneTest() {
		dao.save(new Article(1, "1번글", "없어", "spring"));
		Article a = dao.findOne(1);
		assertEquals(1, a.getAno());
		assertNull(dao.findOne(111));
		assertNotNull(dao.findOne(1));
	}
}
