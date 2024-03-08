<!-- JSTL은 자바함수를 태그처럼 사용하는 기술 -> jstl을 사용할거고 이 jstl을 c라고 부르겠다라고  하는 태그 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>forEach문</title>
</head>
<body>
	<!-- forEach를 사용하는 방법1 -->
	<!-- for(int i=1; i<=5; i++) -->
	<c:forEach begin="1" end="5" var="i"> ${i}</c:forEach>

	<!-- forEach를 사용하는 방법2 -->
	<!-- ArrayList에서 객체를 하나씩 꺼내면서 -->
	<!-- <c:forEach items="${list}" var="board">${board}</c:forEach > -->
	<table>
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
					<td><button class="bno">${board.bno}</button></td>
					<td>${board.title}</td>
					<td>${board.writer}</td>
					<td>${board.writeday}</td>
					<td>${board.readcnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
		$(document).ready(function() {
			$(".bno").on("click", function() {
				// 여러개의 요소 중에서 현재 선택한 요소 고르는 법 $(this)
				alert($(this).text())
			})
		});
	</script>


</body>
</html>