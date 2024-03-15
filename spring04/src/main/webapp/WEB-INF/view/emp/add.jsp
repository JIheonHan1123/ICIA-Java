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
				<form action="/emp/add" method="post">
					<div class="mb-3 mt-3">
						<label for="username" class="form-label">이름:</label> 
						<input type="text" class="form-control" id="ename" placeholder="이름 입력..." name="ename">
					</div>
					<div class="mb-3 mt-3">
						<label for="mgr" class="form-label">관리자 번호 선택 :</label>
						<select id="mgr" name="mgr" class="form-select">
						<c:forEach items="${addInfo.mgrs}" var="mgr">
							<option>${mgr }</option>
						</c:forEach>
						</select>
					</div>
					<div class="mb-3 mt-3">
						<label for="sal" class="form-label">급여:</label>
						<input type="number" class="form-control" id="sal" placeholder="급여 입력..." name="sal">
					</div>
					<div class="mb-3 mt-3">
						<label for="job" class="form-label">담당 업무 선택 :</label>
						<select id="job" name="job" class="form-select">
						<c:forEach items="${addInfo.jobs}" var="job">
							<option>${job }</option>
						</c:forEach>
						</select>
					</div>
					<div class="mb-3 mt-3">
						<label for="deptno" class="form-label">부서 번호 선택 :</label>
						<select id="deptno" name="deptno" class="form-select">
						<c:forEach items="${addInfo.deptnos}" var="deptno">
							<option>${deptno }</option>
						</c:forEach>
						</select>
					</div>
					<div class="mb-3 mt-3">
						<label for="hiredate" class="form-label">입사일:</label>
						<input type="date" class="form-control" id="hiredate" placeholder="미입력시 오늘로 처리..." name="hiredate">
					</div>
					<div class="mb-3 mt-3 d-grid">
						<button class="btn btn-outline-primary">추가하기</button>
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