<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	const message = '${message}';
	console.log(message);
	if(message!='')
		alert(message);
});
</script>
<title>Insert title here</title>
</head>
<body>
	아무나 접근 가능
	<ul>
		<li><a href="/login">로그인 페이지</a></li>
		<li><a href="/sample3">로그인 접근가능</a></li>
		<li><a href="/sample4">USER 접근가능</a></li>
		<li><a href="/sample5">ADMIN 접근가능</a></li>
	</ul>
</body>
</html>