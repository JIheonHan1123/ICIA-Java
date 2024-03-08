<!-- JSTL은 자바함수를 태그처럼 사용하는 기술 -> jstl을 사용할거고 이 jstl을 c라고 부르겠다라고  하는 태그 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>forEach문</title>
</head>
<body>

	<div id="app">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>읽기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.bno}</td>
						<td>${board.title}</td>
						<td>${board.writer}</td>
						<td>${board.writeday}</td>
						<td>${board.readcnt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- WEB-INF의 의미: 브라우저에서 직접 접속할 수 없다. 서버에서만 접속 가능하다(오직 forward 를 통해서만)  -->
		<!-- <div style="width: 500px; margin: 0 auto;">  -->
		<div style="display: flex; justify-content: center;">
			<ul class="pagination">
				<c:if test="${pagination.prev>0}">
					<li class="page-item"><a class="page-link" href="#">이전으로</a></li>
				</c:if>
				<c:forEach begin="${pagination.start}" end="${pagination.end}" var="i">
					<c:if test="${i==pagination.pageno}">
						<li class="page-item active"><a class="page-link" href="/sample4/jstl4?pageno=${i}">${i}</a></li>
					</c:if>
					<c:if test="${i!=pagination.pageno}">
						<li class="page-item"><a class="page-link" href="/sample4/jstl4?pageno=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pagination.next>0}">
					<li class="page-item"><a class="page-link" href="#">다음으로</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>