<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!-- Tag Library: jsp에서 자바 함수를 태그처럼 사용할 수 있는 기술 -->
<!-- => 로그인 여부, 로그인 아이디, 권한 체크 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
	<p>루트 페이지입니다</p>
	<!-- sec:authorize 태그로 권한체크: 어떤 체크냐? 로그인이 되어있는 애들만 화면 나오게 -->
	<sec:authorize access="isAuthenticated()">
		<form action="/member/logout" method="post">
			<button id="logout">로그아웃</button>
		</form>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<form action="/member/logout" method="post">
			<a href="/member/login">로그인</a>
		</form>
	</sec:authorize>
</body>
</html>