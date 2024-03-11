package com.example.servlet1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex03")
public class ExampleServlet03 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Integer a = request.getParameter("a"); 이러면 에러
		// Why? getParameter()로 꺼내면 무조건 문자열임
		// 문자열을 가져와서 숫자로 바꾸는 작업을 해줘야 한다

		// 문자열 >> 숫자
		Integer a = Integer.parseInt(request.getParameter("a"));
		System.out.println(a); // 현재 a 값이 없으면 null 인데 null 을 정수로 변환하지 못하기 때문에 에러뜸
		// !!! 어떤 객체가 null 인 것은 에러가 아님. But! null 인 객체를 사용하는 것이 오류 !!!
		//
	}

}
