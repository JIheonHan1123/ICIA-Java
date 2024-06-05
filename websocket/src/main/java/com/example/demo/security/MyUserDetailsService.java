package com.example.demo.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

@Component
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return User.builder().username(username).password(encoder.encode("1234")).roles("USER").build();
	}
}
