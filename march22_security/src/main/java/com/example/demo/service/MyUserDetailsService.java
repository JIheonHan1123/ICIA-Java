package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// 스프링 시큐리티에서 사용자 정보 읽어오는 서비스
// 실제로는 DB에서 읽어와야 하지만 
// 지금은 그냥 연습용으로 USER 권한 사용자 한명을 추가하는 코드가 들어가있음 (ID: 로그인한 아이디, PW: 1234)

@Component
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return User.builder().username(username).password(encoder.encode("1234")).roles("USER").build();
	}
}
