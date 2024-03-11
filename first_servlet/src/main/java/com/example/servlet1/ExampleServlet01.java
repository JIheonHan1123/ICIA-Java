package com.example.servlet1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet
// 서버에서 실행되는 자바 클래스
// 1. @WebServlet("주소")
// 2. doGet()
// 3. doPost()
@WebServlet("/ex01")
public class ExampleServlet01 extends HttpServlet {

	// private static final long serialVersionUID = 1L;
	// 얘는 객체를 저장할 때, 읽어올 때 클래스를 구별하기 위한 번호
	// 이 문법 거의 안쓴다 -> 스카웃 같은 존재

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("외부에서 /ex01을 통해 나를 호출했어요");
	}
}
