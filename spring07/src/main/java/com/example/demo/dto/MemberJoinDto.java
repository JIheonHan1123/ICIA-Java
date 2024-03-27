package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Member;
import com.example.demo.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MemberJoinDto { // 컨트롤러 작업하는 클래스
	// 어제 js로 했던 검증들 자바로 해보는거임
	// 어제 js코드는 값을 입력하지 않으면 패턴을 통과하지 못하지만
	// 자바는 값을 입력하지 않아도 패턴을 통과한다. => 왜? 그건 만든새끼한테 따져야지...
	// => 해결방법: 어노테이션을 하나 더 걸어준다

	@NotEmpty(message = "아이디는 필수입력입니다")
	@Pattern(regexp = "^[a-zA-z0-9]{6,10}$", message = "영숫자 6~10자입니다")
	private String username;

	@NotEmpty(message = "비밀번호는 필수입력입니다")
	@Pattern(regexp = "^[a-zA-z0-9]{6,10}$", message = "영숫자 8~10자입니다")
	private String password;

	@NotEmpty(message = "이메일은 필수입력입니다")
	@Email(message = "잘못된 이메일입니다")
	private String email;

	@NotNull(message = "생년월일은 필수입력입니다")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // html로 날짜를 선택하면 2024-03-27 형식의 문자열
	private LocalDate birthday;

	private MultipartFile profile;

	public Member toEntity(String 암호화비밀번호, String profile) {
		return new Member(username, 암호화비밀번호, email, birthday, LocalDate.now(), profile, Role.USER);
	}
}