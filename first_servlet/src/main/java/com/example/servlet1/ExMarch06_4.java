package com.example.servlet1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사용자가 숫자를 2개 입력하면 더해서 결과를 출력하자 -> 입력, 출력 jsp가 2개 필요
// 서블릿에서 get: 입력화면으로 forward
// 서블릿에서 post: 결과하면으로  forward 또는 다른 작업으로 redirect

@WebServlet("/ExMarch06_4")
public class ExMarch06_4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("exmarch06_4_1.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long val1 = Long.parseLong(request.getParameter("val1"));
		Long val2 = Long.parseLong(request.getParameter("val2"));
		Long result = val1 + val2;

		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("exmarch06_4_2.jsp");
		rd.forward(request, response);
	}
}
