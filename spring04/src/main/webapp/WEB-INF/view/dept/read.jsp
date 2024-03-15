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
				<h1>부서정보</h1>
				<table class="table">
					<tr>
						<td>부서번호</td><td>${deptInfo.dept.deptno }</td>
					</tr>
					<tr>
						<td>부서명</td><td>${deptInfo.dept.dname }</td>
					</tr>
					<tr>
						<td>근무지</td><td>${deptInfo.dept.loc }</td>
					</tr>
				</table>
				<h1>부서원 정보</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>부서명</th>
							<th>근무지</th>
						</tr>
					</thead>
					<tbody>
				<thead>
						<tr>
							<th>사번</th>
							<th>이름</th>
							<th>입사일</th>
							<th>업무</th>
							<th>부서번호</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${deptInfo.dept.emps}" var="emp">
							<tr>
								<td>${emp.empno }</td>
								<td><a href="/dept2/emp/read?empno=${emp.empno }">${emp.ename }</a></td>
								<td>${emp.hiredate }</td>
								<td>${emp.job }</td>
								<td>${emp.deptno }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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