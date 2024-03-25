<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>비로그인만 접근가능</p> 
	<form action="/login" method="post">
		<input type="text" name="username" value="spring">
		<input type="password" name="password" value="1234">
		<button>로그인</button>
	</form>
</body>
</html>