package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.NewBoardDao;
import com.example.demo.entity.NewBoard;

@SpringBootTest
class NewBoardDaoTest {
	@Autowired
	private NewBoardDao newBaordDao; // dao는 꼭 테스트 해줘야 함

	// @Transactional // 테스트에서 사용하는 이 어노테이션은 자동으로 rollback 이 된다
	// @Test
	public void writeTest() {
		NewBoard newboard = new NewBoard(null, "aaa", "bbb", "spring", null);
		assertEquals(1L, newBaordDao.write(newboard));
	}

	// @Test
	public void 게시판초기화() {
		for (int i = 0; i < 123; i++) {
			NewBoard b = new NewBoard(null, i + "번째 글", i + "번째 글", "spring", null);
			newBaordDao.write(b);
		}
	}

	@Test
	public void findAllTest() {
		assertEquals(10L, newBaordDao.findAll(10L, 20L).size());
	}

}
