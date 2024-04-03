package com.example.demo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.security.web.access.*;

import com.example.demo.security.*;

@EnableMethodSecurity(prePostEnabled=true, securedEnabled=true)
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	@Autowired
	private MyLoginFailureHandler myLoginFailureHandler;
	
	//@Bean은 리턴값을 스프링빈으로 등록
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws 	Exception {
		// csrf 끄기
		// http.csrf(csrf->csrf.disable());
		
		// form로그인(우리가 보통 말하는 로그인)
		// 로그인 페이지 url, 로그인 처리 url, 성공했을 때, 실패했을 때
		http.formLogin(s->s.loginPage("/member/login")
			.loginProcessingUrl("/member/login")
			.defaultSuccessUrl("/")
			.failureHandler(myLoginFailureHandler)
		);
	
		http.logout(logout->logout.logoutUrl("/member/logout")
			.logoutSuccessUrl("/"));
		
		// 403처리
		http.exceptionHandling(e->e.accessDeniedHandler(accessDeniedHandler));
		
		return http.build();
		
	}	
}
