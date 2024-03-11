<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		Java Server Page는 원래 html과 자바를 함께 사용하기위해 만들어진 템플릿
		JSP는 WAS에서 실행되어 html을 실행한다
		=> 개같이 멸망  
		
		자바객체를 출력하는 용도: EL로 jsp가 되살아난다
	 -->
	 서블릿이 보낸 값: ${hello}
</body>
</html>