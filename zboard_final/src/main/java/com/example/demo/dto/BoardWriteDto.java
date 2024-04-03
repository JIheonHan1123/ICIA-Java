package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardWriteDto {
	// NotEmpty를 안걸면 제목없고 내용없는 글을 작성 가능
	@NotEmpty(message = "제목을 입력하세요") // 원래는 if문을 걸어야 하는데
	private String title;
	@NotEmpty(message = "내용을 입력하세요")
	private String content;
}
