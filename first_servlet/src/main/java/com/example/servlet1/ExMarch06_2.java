package com.example.servlet1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExMarch06_2")
public class ExMarch06_2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹은 request가 떠나는 여행
		// 어떤 작업이 끝나면 request는 파괴됨

		// 이 문자열을 jsp에 넘겨주자
		String hello = "안녕하세요";
		// 어떻게 넘겨주냐? request에 담아서 jsp로 토스
		request.setAttribute("hello", hello); // reauest에 담아서
		RequestDispatcher rd = request.getRequestDispatcher("exmarch06_2.jsp");// jsp로 토스

		// forward !!!!! 매우중요 !!!!!
		// 서블릿에서 jsp로 이동하는 것을 forward라고 한다: forward는 주소가 바뀌지 않는다
		rd.forward(request, response);

	}
}
