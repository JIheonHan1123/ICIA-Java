package com.example.servlet1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExMarch06_3")
public class ExMarch06_3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "ㅎㄱㄷ";
		Long age = 20L;

		request.setAttribute("myname", name);
		request.setAttribute("myage", age);
		RequestDispatcher rd = request.getRequestDispatcher("exmarch06_3.jsp");

		rd.forward(request, response);

	}
}
