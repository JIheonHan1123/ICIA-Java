<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/memo" method="post">
		<input type="text" name="title" value="메모 제목"><br>
		<input type="text" name="content" value="메모 내용"><br>
		<input type="text" name="sender" placeholder="보내는 사람..."><br>
		<input type="text" name="receiver" placeholder="받는 사람..."><br>
		<button>보내기</button>
	</form>
</body>
</html>