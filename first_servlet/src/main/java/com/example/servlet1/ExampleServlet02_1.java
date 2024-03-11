package com.example.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02")
public class ExampleServlet02_1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 사용자 요청 정보는 request 객체에 담겨있음
		// ex) <input type="text", name="name">
		String name = request.getParameter("name");
		System.out.println(name); // 콘솔에 출력
		// http://localhost:8081/first_servlet/ex02 => null
		// http://localhost:8081/first_servlet/ex02?name=황현성 => 황현성

//		///////////////////////////////////////////////////////////////////////////////////////////////////////

		// 사용자에게 응답하는 객체가 response
//		System.out.println(); 는 
//		
//		class System { 
//			public static PrintWriter out; 
//		}
//		  
//		System 클래스는 컴퓨터에 해당하는 클래스임 출력기능을 System이 직접 구현하는 것이 아니라 자바 객체를 사용

		// 아래 2개를 해줘야 한글 제대로 나옴
		response.setCharacterEncoding("UTF-8"); // 응답 언어 설정
		response.setContentType("text/html"); // 응답 형식 설정 (응답객체에 담긴 데이터의 형식을 웹브라우저에 알려준다)
		// 브라우저는 형식에 따라 동작함. aaa/bbb 이런식으로 알수없는 형식을 주면 다운로드 창이 뜨는 것이 기본
		// text/plain: 그냥 글자
		// text/html: html. 줄 바꾸려면 <br>이 필요

//		PrintWriter out = response.getWriter();
//		out.println("당신의 이름: " + name); // 지금은 서버에서 한글 깨져서 나옴
//		out.println("Your name is: " + name);

		// 백에서 view를 만들어서 프론트로 보내준다 (한 90년대 방식)
		PrintWriter out = response.getWriter();
		String html = "<html><head></head></html>";
		html += "<div style='color:blue;'> 당신의 이름: " + name + "</div>";
		html += "</body></html>";
		out.println(html);
	}

}
