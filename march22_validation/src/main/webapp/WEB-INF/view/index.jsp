<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>루트 페이지</h1>
	<div>${message }</div>
	<ul>
		<li><a href="/save">사원 추가 실패</a></li>
		<li><a href="/delete1">Emp를 이용한 삭제 실패</a></li>
		<li><a href="/delete2">Optional을 이용한 삭제 실패</a></li>
	</ul>
</body>
</html>