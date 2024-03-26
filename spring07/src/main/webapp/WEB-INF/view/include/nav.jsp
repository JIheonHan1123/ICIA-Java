<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!-- jsp는 html과 java를 같이 쓰는거 -->
<!-- Tag Library: jsp에서 자바 함수를 태그 비슷하게 사용할 수 있는 기술 -->
<!-- => JSTL: if문, for문 -->
<!-- => Spring Security Tag Library: 로그인여부, 로그인아이디, 권한체크 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">ICIA</a>
			</div>
			<ul class="navbar-nav" id="menu_parent">
				<!-- sec:authorize 태그로 권한체크: 어떤 체크냐? 로그인이 되어있는 애들만 화면 나오게 -->
				<sec:authorize access="isAnonymous()">
					<!-- 비로그인인 경우 나타난다 -->
					<li class="nav-item"><a href="/member/join" class="nav-link">회원가입</a></li>
					<li class="nav-item"><a href="/member/login" class="nav-link">로그인</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<!-- 로그인인 경우 나타난다 -->
					<li class="nav-item"><a href="/member/write" class="nav-link">글쓰기</a></li>
					<li class="nav-item"><a href="/member/read" class="nav-link">내정보</a></li>
					<li class="nav-item"><a href="/member/logout" class="nav-link">로그아웃</a></li>
				</sec:authorize>
				
				<!-- 위에는 로그인 여부로 구분한거고 이거는 권한으로 구분하는거 -->
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item"><a href="/member/admin" class="nav-link">관리자메뉴</a></li>			
				</sec:authorize>
			</ul>
		</div>
	</div>
</body>
</html>



