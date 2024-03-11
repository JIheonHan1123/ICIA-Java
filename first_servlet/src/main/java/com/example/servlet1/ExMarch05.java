package com.example.servlet1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. WAS에 실행하는 특수한 형식의 자바 클래스
// 2. 실행하는 방식 -> 서블릿은 주소를 가져야 한다
//		사용자 요청을 웹서버가 접수
//		웹서버가 처리 못 할 경우 요청객체를 WAS로 전달
//	3. get: 서버의 정보를 변경하지 않는다 -> 보통 읽기 요청(재실행 ok)
//			  요청정보가 주소창에 노출(querystring) -> 즐겨찾기 가능
//		post: 서버의 정보를 변경하는 요청 ->  추가, 변경

@WebServlet("/ExampleServletMarch05_1")
public class ExMarch05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청과 응답객체를 편지라고 합시다
		// 편지지와 편지봉투가 있을텐데
		// 요청/응답의 내용(편지지)을 body
		// 요청/응답의 부가정보(편지봉투)를 header

		// 사용자의 IP주소
		System.out.println(request.getRemoteAddr());

		// 사용자가 요청한 서버 주소
		System.out.println(request.getRequestURI());
	}
}
