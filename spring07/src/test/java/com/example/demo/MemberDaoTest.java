package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.MemberDao;
import com.example.demo.entity.Member;
import com.example.demo.entity.Role;

@SpringBootTest
class MemberDaoTest {
	@Autowired
	private MemberDao dao;

	// @Test
	public void initTest() {
		assertNotNull(dao);
	}

	// @Test
	public void saveTest() {
		Member m = new Member("spring", "1234", "spring@naver.com", LocalDate.now(), LocalDate.now(), "spring.jpg", Role.USER);
		assertEquals(1L, dao.save(m));
	}

	// 테스트는 성공, 실패 모두 테스트해야함
	// @Test
	public void existsByUsernameTest() {
		assertEquals(true, dao.existsByUsername("spring"));
		assertEquals(false, dao.existsByUsername("winter"));
	}

	// @Test
	public void findUsernameByEmailTest() {
		assertEquals("spring", dao.findUsernameByEmail("spring@naver.com"));
		assertNull(dao.findUsernameByEmail("spring@kakao.com"));
	}

	@Test
	public void 나머지다테스트() {
		assertEquals(1L, dao.changePassword("aaa", "spring"));
		assertEquals(0L, dao.changePassword("aaa", "winter"));

		assertNotNull(dao.findByUsername("spring"));
		assertNull(dao.findByUsername("winter"));

		assertEquals(1L, dao.changeEmail("a@a.com", "spring"));
		assertEquals(0L, dao.changeEmail("a@a.com", "winter"));

		assertEquals(1L, dao.deleteByUsername("spring"));
		assertEquals(0L, dao.deleteByUsername("winter"));
	}
}
