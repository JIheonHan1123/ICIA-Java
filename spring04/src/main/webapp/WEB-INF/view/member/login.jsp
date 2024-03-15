<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/main.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		if(location.search=='?error') {
			alert("로그인에 실패했습니다");
		} else if(location.search=='?required') {
			alert("로그인이 필요합니다");
		}
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="page">
		<header>
			<jsp:include page="/WEB-INF/view/include/header.jsp" />
		</header>
		<nav>
			<jsp:include page="/WEB-INF/view/include/nav.jsp" />
		</nav>
		<main>
			<aside>
				<jsp:include page="/WEB-INF/view/include/aside.jsp" />
			</aside>
			<section>
				<form action="/member/login" method="post">
					<div class="mb-3 mt-3">
						<label for="username" class="form-label">아이디:</label> 
						<input type="text" class="form-control" id="username" placeholder="아이디 입력..." name="username">
					</div>
					<div class="mb-3 mt-3">
						<label for="password" class="form-label">비밀번호:</label>
						<input type="password" class="form-control" id="password" placeholder="비밀번호 입력..." name="password">
					</div>
					<div class="mb-3 mt-3 d-grid">
						<button class="btn btn-outline-primary">로그인</button>
					</div>
				</form>
			</section>
			<aside>
				<jsp:include page="/WEB-INF/view/include/aside.jsp" />
			</aside>
		</main>
		<footer>
			<jsp:include page="/WEB-INF/view/include/footer.jsp" />
		</footer>
	</div>
</body>
</html>