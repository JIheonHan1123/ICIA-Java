package com.icia.b.feb06.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

// junit은 함수의 동작을 테스트한다. main함수를 대신한다
public class TodoDaoTest {

	// 테스트 할 객체 생성
	// 필드 초기화
//	     1. 필드 만들면서 바로 초기화 (instance 초기화)
//	     2. 정적 초기화
//	     3. 생성자에서 초기화
	TodoDao dao = new TodoDao();

	// junit으로 테스트를 돌리는 함수는 반드시 public void
	@Test
	public void saveTest() {
		boolean result = dao.save(new Todo(1, "1번 할일"));
		// assertEquals (원하는 값, 실제 값)
		assertEquals(true, result);
	}

	@Test
	public void findAllTest() {
		// 자바에서 size를 가져오는 메소드는 getSize()여야 한다.
		// 근데 ArrayList는 너무 옛날 메소드라 이름이 개판임
		assertEquals(0, dao.findAll().size());
		dao.save(new Todo(1, "1번 할일"));
		assertEquals(1, dao.findAll().size());
	}

	@Test
	public void findOneTest() {
		dao.save(new Todo(1, "1번 할 일"));
		assertNotNull(dao.findOne(1));
		assertNull(dao.findOne(200));
	}

	@Test
	public void updateTest() {
		dao.save(new Todo(1, "1번 할 일"));
		assertEquals(true, dao.update(1, "변경했습니다"));
		assertEquals(false, dao.update(200, "변경했습니다"));
	}

	@Test
	public void deleteTest() {
		dao.save(new Todo(1, "1번 할 일"));
		assertEquals(true, dao.delete(1));
		assertEquals(false, dao.delete(1));
	}
}
