package com.example.servlet1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.A_Product;

@WebServlet("/ExMarch06_1")
public class ExMarch06_1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Long price = Long.parseLong(request.getParameter("price"));

		A_Product p = new A_Product(name, price);

		// 동적으로 html실행
		String html = "<html><head><body><ul>";
		html += "<li>" + p.getName() + "</li>";
		html += "<li>" + p.getPrice() + "</li>";
		html += "</ul></body></html>";

	}
}
