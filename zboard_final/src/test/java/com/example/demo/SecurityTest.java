package com.example.demo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dao.MemberDao;
import com.example.demo.entity.Member;
import com.example.demo.entity.Role;

// 시큐리티를 위한 회원 추가 
@SpringBootTest
public class SecurityTest {
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private MemberDao dao;

	// @Test
	public void joinTest() {
		String encodedPassword = encoder.encode("1234");
		Member m = new Member("spring", encodedPassword, "hasaway@naver.com", LocalDate.now(), LocalDate.now(), "spring.jpg", Role.USER);
		dao.save(m);
	}

	// @Test
	public void 비밀번호변경() {
		String 암호 = encoder.encode("1234");
		dao.changePassword(암호, "winter");
	}

	@Test
	public void 암호화확인() {
		String 암호 = encoder.encode("1234");
		System.out.println(암호);
		dao.changePassword(암호, "winter");

		String password = dao.findByUsername("winter").getPassword();
		System.out.println(password);

		System.out.println(encoder.matches("1234", password));

	}
}
