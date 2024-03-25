package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 스프링 설정파일
@Configuration
@EnableWebSecurity
// PreAuthorize와 Secured 어노테이션을 활성화해주는 어노테이션
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

	// @Component는 내가 만든 클래스를 스프링빈으로 등록
	@Bean // @Bean은 남이 만든 클래스의 객체를 스프링빈으로 등록
	public PasswordEncoder passwordEncoder() {
		// 스프링 시큐리티에서는 무조건 비밀번호를 암호화해야함
		return new BCryptPasswordEncoder(); // BCrypt: 비밀번호를 암호화하는 암호화 알고리즘 (60글자)
	}

	// 스프링 시큐리티 설정
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // throws = 예외를 처리하지 않겠다

		// csrf: 페이지의 위/변조를 막기 위한 기술
		// 근데 이걸 사용하면 우리가 피곤함 => 일단 꺼두자
		// ex) 회원가입 만든다고 했을 때 초반에 몇번 실패할건데 뒤로가기해서 다시 만들고 할 때 "뒤로가기가 막힘"
		http.csrf(a -> a.disable());

		// 전통적인 로그인 설정
		// 로그인 창 보여주는 주소: /login
		// 로그인 처리하는 주소: /login (로그인 처리는 스프링 시큐리티가 알아서 한다)
		// 로그인에 성공하면 갈 주소: /
		// 로그인에 실패하면 갈 주소: /login?error
		http.formLogin(b -> b.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/").failureUrl("/login?error"));

		// 로그아웃 설정
		http.logout(c -> c.logoutUrl("/member/logout").logoutSuccessUrl("/"));

		return http.build();

	}
}
