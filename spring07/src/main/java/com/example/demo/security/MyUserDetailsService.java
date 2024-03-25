package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MemberDao;
import com.example.demo.entity.Member;

// 사용자 정보를 읽어와 스프링 시큐리티에 넘겨주는 역할
// 이 폴더에 만든 3개 중에 나머지 2개는 선택이지만 지금 이거는 필수임 !!! 
@Component
public class MyUserDetailsService implements UserDetailsService {
//	@Autowired // 비밀번호 암호화 객체
//	private PasswordEncoder passwordEncoder; // 없어도 될 거 같아서 일단 주석처리
	@Autowired
	private MemberDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member m = dao.findByUsername(username);
		// null처리
		// throws: 예외를 처리하지 않겠다
		// throw: 개발자가 예외를 발생시킨다.

		// null은 예외가 아니기 때문에
		// null이 들어오면 이 예외를 발생시켜라.
		if (m == null) {
			throw new UsernameNotFoundException("사용자없음");
		}

		// 스프링 시큐리티에서 권한은 단순한 문자열
		// enum을 문자열로 바꾼다
		String role = m.getRole().name();

		// 사용자 권한 정보를 담는 UserDetails 객체를 리턴
		// UserDetails에는 최소한 아이디, 비밀번호, 권한을 담아야 한다
		return User.builder().username(username).password(m.getPassword()).roles(role).build();
	}
	// DB만 쓰면 위 코드처럼 하면 되는데
	// 카카오로그인, 네이버로그인 이런거는 엄청 더 복잡해짐 ex) 구글로그인 100페이지 정도됨.
}