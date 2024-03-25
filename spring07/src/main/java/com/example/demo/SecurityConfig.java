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
//	cf) 오류
//	- Exception: 프로그래머가 대처할 수 있는 가벼운 오류
//	- Error: 심각한 오류

	// 1. 자바 예외처리
	// 1) try{ 예외가 발생할 수 있는 코드 } catch { 예외를 처리하는 코드 }
	// 2) throws 예외객체: 예외를 처리하지 않겠다

	// 2. 스프링 예외처리
	// @ExceptionHandler라는 예외전담 컨트롤러가 있다.
	// -> 그래서 스프링을 사용할 때는 예외는 가급적 throws 해야 한다.

	// 3. 필터
	// Filter: 컨트롤러 앞에서 실행되는 클래스
	// 스프링 시큐리티는 인증작업을 잘게 쪼개서 10여개의 필터로 작업을 수행
	// 필터들이 줄을 서있다 = 필터체인이라고 함 => SecurityFilterChain

	// 4. 스프링 빈 생성 어노테이션
	// - @Bean
	// - @Component <- @Controller, @Service, @Repository
	// - @Configuration: 스프링 설정 빈
	// - @Mapper: 스프링 어노테이션이 아니라 마이바티스 어노테이션 (마이바티스가 인터페이스를 스프링에 dao로 등록한다)

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
		http.csrf(csrf -> csrf.disable());

		// form로그인 (우리가 보통 말하는 로그인)
		// 로그인 페이지 url, 로그인 처리 url, 성공했을 때, 실패했을 때
		http.formLogin(s -> s.loginPage("/member/login").loginProcessingUrl("/member/login").defaultSuccessUrl("/").failureUrl("/member/login"));

		// 로그아웃처리
		http.logout(logout -> logout.logoutUrl("/member/logout").logoutSuccessUrl("/"));

		// 403처리
		http.exceptionHandling(e -> e.accessDeniedHandler(accessDeniedHandler));

		return http.build();
	}

}
