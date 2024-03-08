<!-- JSTL은 자바함수를 태그처럼 사용하는 기술 -> jstl을 사용할거고 이 jstl을 c라고 부르겠다라고  하는 태그 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- c:if문에는 else if 또는 else가 없다 -->
	<div>
		<c:if test="${username == null}">로그인이 필요합니다</c:if>
		<c:if test="${username != null}">${username}님 환영합니다</c:if>
	</div>

	<!-- else if나 else를 쓰려면 -->
	<div>
		<c:choose>
			<c:when test="${username==null}">
				로그인이 필요합니다
			</c:when>
		</c:choose>
		<c:otherwise>
			${username}님 환영합니다
		</c:otherwise>
	</div>

</body>
</html>