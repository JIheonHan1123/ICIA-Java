<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#logout').click(function(e) {
			e.preventDefault();
			const html = `
				<form action="/member/logout" method="post">
				</form>
			`;
			$(html).appendTo($('body')).submit();
		});
	})
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">Emp</a>
			<ul class="navbar-nav">
				<c:if test="${username==null }">
					<li class="nav-item">
						<a class="nav-link" href="/member/login">로그인</a>
					</li>
				</c:if>
				<c:if test="${username!=null}">
					<li class="nav-item">
						<a class="nav-link" href="/emp/add">사원추가</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="logout" href="#">로그아웃</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>



