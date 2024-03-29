<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<p>${msg}</p>
	비밀번호 확인
	<form action="/member/check-password" method="post">
		<input type="password" name="password">
		<input type="hidden" name="_csrf" value="${_csrf.token}">
		<button>확인</button>
	</form>
</body>
</html>