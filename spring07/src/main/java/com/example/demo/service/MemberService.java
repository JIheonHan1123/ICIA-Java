package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.MemberJoinDto;
import com.example.demo.entity.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private PasswordEncoder encoder;

	@Value("c:/upload/profile/")
	private String PROFILE_FOLDER;

	@Value("profile.png")
	private String DEFAULT_PROFILE;

	@Value("http://localhost:8081/profile/")
	private String PROFILE_URL;

	public Boolean idCheck(String username) {
		return !memberDao.existsByUsername(username);
	}

	public Boolean join(MemberJoinDto dto) {
		MultipartFile mf = dto.getProfile();
		String profilename = DEFAULT_PROFILE;

		// <input type="file" name은 file>이 비어있는 상태로
		// 업로드한답ㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂ
		// 이경우 MultipartFile은 null이 이버 비어있다 --> isEmpty로 체크
		if (mf.isEmpty() == false) { // 사진을 업로드하지 않은 경우
			String 확장자 = FilenameUtils.getExtension(mf.getOriginalFilename());
			String 저장이름 = UUID.randomUUID().toString() + "." + 확장자;

			// 사진을 저장하기위해 파일객체를 생성
			File file = new File(PROFILE_FOLDER, 저장이름);

			// 예외처리
			// try-catch: 개발자가 처리
			// throws: 스프링이처리 -> 작업이 실패했다는 메시지 출력
			try {
				mf.transferTo(file);
				profilename = 저장이름;
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		String 암호화비밀번호 = encoder.encode(dto.getPassword());
		Member member = dto.toEntity(암호화비밀번호, PROFILE_URL + profilename);
		return memberDao.save(member) == 1L;
	}
}
