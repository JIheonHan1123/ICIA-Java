<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/example23/end" method="post" enctype="multipart/form-data">
		<!-- multiple 속성을 지정 >> 파일 여러개 입력 -->
		<input type="file" multiple>
		<hr>
		<input type="text" name="username" value="spring">
		<input type="file" name="profile">
		<input type="file" name="profile">
		<input type="file" name="profile">
		<button>보내기</button>
	</form>
</body>
</html>