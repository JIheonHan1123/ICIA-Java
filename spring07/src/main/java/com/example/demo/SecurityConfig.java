package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.example.demo.security.MyLoginFailureHanlder;

// 스프링 6.2
// 스프링 시큐리티로 웹 보안을 활성화 + @PreAuthorize, @Secured 활성화
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	@Autowired
	private MyLoginFailureHanlder myLoginFailureHanlder;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// csrf 끄기
		// http.csrf(csrf -> csrf.disable());

		// form로그인 (우리가 보통 말하는 로그인)
		// 로그인 페이지 url, 로그인 처리 url, 성공했을 때, 실패했을 때
		http.formLogin(s -> s.loginPage("/member/login").loginProcessingUrl("/member/login").defaultSuccessUrl("/").failureHandler(myLoginFailureHanlder));

		// 로그아웃처리
		http.logout(logout -> logout.logoutUrl("/member/logout").logoutSuccessUrl("/"));

		// 403처리
		http.exceptionHandling(e -> e.accessDeniedHandler(accessDeniedHandler));

		return http.build();
	}

}
